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
import eeit124.group4._03_cultureAndCreativeShopsCMS.util.CustomizedTypeConversion;
import eeit124.group4.hibernateUtil.HibernateUtil;

@WebServlet(name="CreateShopBeanAction", urlPatterns = "/CreateShopBeanAction")
public class CreateShopBeanAction extends HttpServlet {
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
			String name = request.getParameter("name");
			String representImage = request.getParameter("representImage");
			String intro = request.getParameter("intro");
			String cityName = request.getParameter("cityName");

			String address = request.getParameter("address");
			String longitude = request.getParameter("longitude");
			String latitude = request.getParameter("latitude");
			String openTime = request.getParameter("openTime");
			String phone = request.getParameter("phone");

			String fax = request.getParameter("fax");
			String email = request.getParameter("email");
			String facebook = request.getParameter("facebook");
			String website = request.getParameter("website");
			String clicks = request.getParameter("clicks");
			
			System.out.println(name);
			System.out.println(longitude);
			System.out.println(fax);
			System.out.println(intro);
			System.out.println(cityName);
			
			ShopBean shop = new ShopBean();

			shop.setName(name);
			shop.setRepresentImage(representImage);
			shop.setIntro(intro);
			shop.setCityName(cityName);

			shop.setAddress(address);
			shop.setLongitude(CustomizedTypeConversion.customizedParseDouble(longitude));
			shop.setLatitude(CustomizedTypeConversion.customizedParseDouble(latitude));
			shop.setOpenTime(openTime);
			shop.setPhone(phone);

			shop.setFax(fax);
			shop.setEmail(email);
			shop.setFacebook(facebook);
			shop.setWebsite(website);
			shop.setClicks(CustomizedTypeConversion.customizedParseInt(clicks));

//			ShopBeanService sbs = new ShopBeanService(session);
			session.save(shop);
			
			String ccShopsCreateMsg = "商店資料新建成功";
			request.setAttribute("ccShopsCreateMsg", ccShopsCreateMsg);

		} catch (Exception e) {
			e.printStackTrace();

			String ccShopsCreateMsg = "商店資料新建失敗";
			request.setAttribute("ccShopsCreateMsg", ccShopsCreateMsg); // 回傳錯誤訊息
		}

		// 設定回傳屬性值
		RequestDispatcher rd = request.getRequestDispatcher("/_03_cultural_and_creative_shops_cms/create_return.jsp");
		rd.forward(request, response);
		return;

	}

}
