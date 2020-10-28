package eeit124.group4._04_AAARThibernate.action;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import eeit124.group4._04_AAARThibernate.model.ShowBean;
import eeit124.group4._04_AAARThibernate.model.ShowBeanService;
import eeit124.group4.hibernateUtil.HibernateUtil;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {	


//		System.out.println(no);
		String title = request.getParameter("title");
		int category =Integer.parseInt(request.getParameter("category"));
		String location = request.getParameter("location");
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
			ShowBean showBean = new ShowBean();
			showBean.setACT_TITLE(title);
			showBean.setACT_CATEGORY(category);
			showBean.setACT_LOCATION(location);
			showBean.setACT_LOCATION_NAME(locationName);
			showBean.setACT_MAINUNIT(mainunit);
			showBean.setACT_SHOWUNIT(showunit);
			showBean.setACT_DESCRIPTION(description);
			showBean.setACT_STARTDATE(startdate);
			showBean.setACT_ENDDATE(enddate);
			
			showService.insert(showBean);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();	
		}

		response.sendRedirect("/ArtCMS/AAArtAction?page=&category=" + category);
//		response.sendRedirect("index.jsp");


	}
}
	