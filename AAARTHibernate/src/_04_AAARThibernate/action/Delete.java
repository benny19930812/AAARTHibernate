package _04_AAARThibernate.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _04_AAARThibernate.model.ShowBean;
import _04_AAARThibernate.model.ShowBeanService;
import hibernateweb.util.HibernateUtil;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
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
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		
		int actno = Integer.parseInt(request.getParameter("actno"));
		String page = request.getParameter("page");
		String category = request.getParameter("category");
		String searchString = request.getParameter("searchString");
		System.out.println(searchString);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			ShowBeanService showService = new ShowBeanService(session);

			showService.delete(actno);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		// 導回前頁
		if (category.equals("")) {
//			request.getRequestDispatcher("/SearchAll?page="+ page + "&searchString="+searchString).forward(request, response);
			response.sendRedirect("/HibernateWebProject/SearchAll?page="+ page + "&searchString="+URLEncoder.encode(searchString,"utf-8"));
			System.out.println("&searchString="+searchString);
		}
		else {
			response.sendRedirect("/HibernateWebProject/AAArtAction?page=" + page + "&category=" + category);
		}
			

	}
}
