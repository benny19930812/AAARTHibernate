package eeit124.group4._18_course.action;

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

import eeit124.group4._18_course.model.CourseBeanDAO;
import eeit124.group4._18_course.model.Course_LN;
import eeit124.group4.hibernateUtil.HibernateUtil;

@WebServlet("/_18_course/CourseHibernateServletSelectAll")
public class CourseHibernateServletSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		processAction(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		CourseBeanDAO cDAO = new CourseBeanDAO(session);
		
		List<Course_LN> list = cDAO.selectAll(); 
		
		request.setAttribute("cbeanselectAllList", list);
		
		session.getTransaction().commit(); 
		RequestDispatcher rd = request.getRequestDispatcher("DemoSelectAll.jsp"); 
		rd.forward(request, response);
		return;
		
		

		
	}

}
