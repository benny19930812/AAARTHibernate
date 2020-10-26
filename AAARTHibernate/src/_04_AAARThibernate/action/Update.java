package _04_AAARThibernate.action;

import java.io.IOException;
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

import _04_AAARThibernate.model.ShowBean;
import _04_AAARThibernate.model.ShowBeanService;
import hibernateweb.util.HibernateUtil;

/**
 * Servlet implementation class UpdateOrDelete
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
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

	
//		String page = request.getParameter("page");
//		System.out.println(page);
		

		int actno =Integer.parseInt(request.getParameter("actno"));
		System.out.println(actno);
		
		

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			ShowBeanService showService = new ShowBeanService(session);
			ShowBean showBean = showService.select(actno);
			
			String title = showBean.getACT_TITLE();
			System.out.println(title);
			int category =showBean.getACT_CATEGORY();
			System.out.println(category);
			String location = showBean.getACT_LOCATION();
			String locationName = showBean.getACT_LOCATION_NAME();
			String mainunit = showBean.getACT_MAINUNIT();
			String showunit = showBean.getACT_SHOWUNIT();
			String description = showBean.getACT_DESCRIPTION();
			String startdate = showBean.getACT_STARTDATE();
			System.out.println(startdate);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date date;
			date = sdf.parse(startdate);
			// System.out.println(date);
			System.out.println(date);
			String enddate = showBean.getACT_ENDDATE();
			System.out.println(enddate);

//			ShowBean showBean = SService.select(1000);	
//			System.out.println(showBean.getACT_NO()+":"+showBean.getACT_TITLE()+showBean.getACT_DESCRIPTION());
			
			
			request.setAttribute("actno",actno);
			request.setAttribute("title",title);
			request.setAttribute("category",category );
			request.setAttribute(" location", location );
			request.setAttribute("locationName",locationName );
			request.setAttribute("mainunit",mainunit );
			request.setAttribute("showunit",showunit );
			request.setAttribute("description",description );
			request.setAttribute("startdate",date );
			request.setAttribute("enddate",enddate );
			
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();	
		}
//		response.sendRedirect("_04_AAARThibernate/index.jsp");
//		response.sendRedirect("/AAArtAction2?page="+page+"&category="+category);

//		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/_04_AAARThibernate/UpdateAction.jsp");
		dispatcher.forward(request, response);
		
//		HibernateUtil.closeSessionFactory();		
	
	
	
	}
}
