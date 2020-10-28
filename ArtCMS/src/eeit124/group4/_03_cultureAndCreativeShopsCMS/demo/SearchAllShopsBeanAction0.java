package eeit124.group4._03_cultureAndCreativeShopsCMS.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import eeit124.group4._03_cultureAndCreativeShopsCMS.model.ShopBean;
import eeit124.group4._03_cultureAndCreativeShopsCMS.model.ShopBeanService;
import eeit124.group4.hibernateUtil.HibernateUtil;



@WebServlet("/demoSearch0")
public class SearchAllShopsBeanAction0 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		processAction(request, response);
		
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

//		try {
//			session.beginTransaction();
			
			ShopBeanService sbs = new ShopBeanService(session);
			
			List<ShopBean> shopsInfoList = sbs.selectAll();
			
//			Query<ShopsBean> query = session.createQuery("From ShopsBean", ShopsBean.class);
//			List<ShopsBean> list = query.list();
		
			// 設定回傳屬性值
			request.setAttribute("ShopsInfoList", shopsInfoList);
			RequestDispatcher rd = request.getRequestDispatcher("/_03_shopsCMS/ShopsInfo.jsp");
			rd.forward(request, response);
			return;
			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//
//		} finally {
//			// seseion.close();
//			System.out.println("Session Closed");
//			HibernateUtil.closeSessionFactory();
//		}

	}

}
