package eeit124.group4._35_cms.controller;

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

import eeit124.group4._35_cms.model.EventSpace;
import eeit124.group4._35_cms.model.EventSpaceService;
import eeit124.group4._35_cms.model.InterfaceEventSpaceService;
import eeit124.group4.hibernateUtil.HibernateUtil;

@WebServlet(name = "SelectAll", urlPatterns = "/_35_cms/SelectAll")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		InterfaceEventSpaceService service = new EventSpaceService(session);
		List<EventSpace> list = service.selectAll();
		
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("eventSpaceList",list);
		RequestDispatcher rd = request.getRequestDispatcher("/_35_cms/eventSpaceList.jsp");
		rd.forward(request, response);	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
