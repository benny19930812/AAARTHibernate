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

import eeit124.group4._03_cultureAndCreativeShopsCMS.model.ShopBeanService;
import eeit124.group4.hibernateUtil.HibernateUtil;

@WebServlet(name = "DeleteShopBeanAction", urlPatterns = "/DeleteShopBeanAction")
public class DeleteShopBeanAction extends HttpServlet {
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
			String shopId = request.getParameter("shopId");
			int id = Integer.parseInt(shopId);

			ShopBeanService sbs = new ShopBeanService(session);

			sbs.delete(id);
			
			String ccShopsDeleteMsg = "商店資料刪除成功";
			request.setAttribute("ccShopsDeleteMsg", ccShopsDeleteMsg);

		} catch (Exception e) {
			e.printStackTrace();
			String ccShopsDeleteMsg = "商店資料刪除失敗";
			request.setAttribute("ccShopsDeleteMsg", ccShopsDeleteMsg); // 回傳錯誤訊息
		}
		// 設定回傳屬性值
		RequestDispatcher rd = request.getRequestDispatcher("/_03_cultural_and_creative_shops_cms/delete_return.jsp");
		rd.forward(request, response);
		return;

	}

}
