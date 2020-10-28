package eeit124.group4._04_AAARThibernate.action;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class UpdateOrDelete
 */
@WebServlet("/Update2")
public class Update2 extends HttpServlet {
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
		String searchString = request.getParameter("searchString");
		System.out.println(searchString);
		String page = request.getParameter("page");
		int actno =Integer.parseInt(request.getParameter("actno"));
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
			ShowBean showBean =new ShowBean(); 

			showService.update(actno, title, category, location, locationName, mainunit, showunit, description, startdate, enddate);
		
			
//			request.setAttribute("title",title);
//			request.setAttribute("category",category );
//			request.setAttribute("location", location );
//			request.setAttribute("locationName",locationName );
//			request.setAttribute("mainunit",mainunit );
//			request.setAttribute("showunit",showunit );
//			request.setAttribute("description",description );
//			request.setAttribute("enddate",enddate );
			
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();	
		}

		if (!searchString.equals("")) {

			response.sendRedirect("/ArtCMS/SearchAll?page="+ page + "&searchString="+URLEncoder.encode(searchString,"utf-8"));
		}
		else {
			response.sendRedirect("/ArtCMS/AAArtAction?page=" + page + "&category=" + category);
		}
		
		


//		HibernateUtil.closeSessionFactory();		
	
	
	
	}
}
