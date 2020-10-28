package eeit124.group4._03_cultureAndCreativeShopsCMS.action;

import java.io.IOException;
import java.util.List;

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
import eeit124.group4.hibernateUtil.HibernateUtil;

@WebServlet(name = "UpdateByNameDispatcherAction", urlPatterns = "/UpdateByNameDispatcherAction")
public class UpdateByNameDispatcherAction extends HttpServlet {
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

			ShopBeanService sbs = new ShopBeanService(session);
			List<ShopBean> shopsList = sbs.selectByName(name);
			request.setAttribute("ccShopsList", shopsList);

		} catch (Exception e) {
			e.printStackTrace();

			String ccShopsSerachMsg = "查無此商店名稱";
			request.setAttribute("ccShopsSerachMsg", ccShopsSerachMsg); // 回傳錯誤訊息
		}
		// 設定回傳屬性值
		RequestDispatcher rd = request.getRequestDispatcher("/_03_cultural_and_creative_shops_cms/update_by_name.jsp");
		rd.forward(request, response);
		return;

	}

}
