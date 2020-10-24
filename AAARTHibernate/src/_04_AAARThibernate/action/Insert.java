package _04_AAARThibernate.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		int no =Integer.parseInt(request.getParameter("no"));
//		System.out.println(no);
		String title = request.getParameter("title");
		int category =Integer.parseInt(request.getParameter("category"));
		String location = request.getParameter("location");
//		System.out.println(location);
		String locationName = request.getParameter("locationName");
		String mainunit = request.getParameter("mainunit");
		String showunit = request.getParameter("showunit");
		String description = request.getParameter("description");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			ShowBeanService showService = new ShowBeanService(session);
			ShowBean hBean = new ShowBean();
//			hBean.setACT_NO(no);
			hBean.setACT_TITLE(title);
			hBean.setACT_CATEGORY(category);
			hBean.setACT_LOCATION(locationName);
			hBean.setACT_MAINUNIT(mainunit);
			hBean.setACT_SHOWUNIT(showunit);
			hBean.setACT_DESCRIPTION(description);
			hBean.setACT_STARTDATE(startdate);
			hBean.setACT_ENDDATE(enddate);
			
			showService.insert(hBean);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();	
		}

//		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		response.sendRedirect("_04_AAARThibernate/index.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/_04_AAARThibernate/index.jsp");
//		dispatcher.forward(request, response);
//		HibernateUtil.closeSessionFactory();		
	
	
	
	}
}
	