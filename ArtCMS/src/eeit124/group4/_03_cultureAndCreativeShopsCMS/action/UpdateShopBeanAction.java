package eeit124.group4._03_cultureAndCreativeShopsCMS.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import eeit124.group4._03_cultureAndCreativeShopsCMS.model.ShopBean;
import eeit124.group4._03_cultureAndCreativeShopsCMS.model.ShopBeanService;
import eeit124.group4._03_cultureAndCreativeShopsCMS.util.CustomizedTypeConversion;
import eeit124.group4.hibernateUtil.HibernateUtil;

@WebServlet(name = "UpdateShopBeanAction", urlPatterns = "/UpdateShopBeanAction")
public class UpdateShopBeanAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);

	}

	private void processAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			ShopBean shop = new ShopBean();
			ShopBeanService sbs = new ShopBeanService(session);

			int shopId = Integer.parseInt(request.getParameter("shopId"));
			String name = request.getParameter("name");
			String representImage = request.getParameter("representImage");
			String intro = request.getParameter("intro");
			String cityName = request.getParameter("cityName");

			String address = request.getParameter("address");
			Double longitude =  CustomizedTypeConversion.customizedParseDouble(request.getParameter("longitude"));
			Double latitude = CustomizedTypeConversion.customizedParseDouble(request.getParameter("latitude"));
			String openTime = request.getParameter("openTime");
			String phone = request.getParameter("phone");

			String fax = request.getParameter("fax");
			String email = request.getParameter("email");
			String facebook = request.getParameter("facebook");
			String website = request.getParameter("website");
			int clicks = CustomizedTypeConversion.customizedParseInt(request.getParameter("clicks"));

			shop.setShopId(shopId);
			shop.setName(name);
			shop.setRepresentImage(representImage);
			shop.setIntro(intro);
			shop.setCityName(cityName);

			shop.setAddress(address);
			shop.setLongitude(longitude);
			shop.setLatitude(latitude);
			shop.setOpenTime(openTime);
			shop.setPhone(phone);

			shop.setFax(fax);
			shop.setEmail(email);
			shop.setFacebook(facebook);
			shop.setWebsite(website);
			shop.setClicks(clicks);
			
			
			//查詢商店編號存在後 //執行更新
			if(sbs.checkShopId(shop)) {	
				sbs.update(shopId, name, representImage, intro, cityName, 
						address, longitude, latitude, openTime, phone, 
						fax, email, facebook, website, clicks);				
				
				String ccShopsUpdateMsg = "商店資料更新成功";
				request.setAttribute("ccShopsUpdateMsg", ccShopsUpdateMsg);
				
			} else {
				String ccShopsUpdateMsg = "查無該商店編號，資料更新失敗";
				request.setAttribute("ccShopsUpdateMsg", ccShopsUpdateMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String ccShopsUpdateMsg = "商店資料更新失敗";
			request.setAttribute("ccShopsUpdateMsg", ccShopsUpdateMsg); // 回傳錯誤訊息
		}
		
		// 設定回傳屬性值
		RequestDispatcher rd = request.getRequestDispatcher("/_03_cultural_and_creative_shops_cms/update_return.jsp");
		rd.forward(request, response);
		return;

	}

}
