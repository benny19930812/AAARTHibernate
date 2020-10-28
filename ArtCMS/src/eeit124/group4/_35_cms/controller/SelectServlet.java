package eeit124.group4._35_cms.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet(name = "Select", urlPatterns = "/_35_cms/Select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		InterfaceEventSpaceService service = new EventSpaceService(session);
		EventSpace bean = service.select(1);
		
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html;charset=UTF-8");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
