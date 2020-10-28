package eeit124.group4._35_cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import eeit124.group4._35_cms.model.EventSpaceService;
import eeit124.group4._35_cms.model.InterfaceEventSpaceService;
import eeit124.group4.hibernateUtil.HibernateUtil;

@WebServlet(name = "Delete", urlPatterns = "/_35_cms/Delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		InterfaceEventSpaceService service = new EventSpaceService(session);
		if(service.delete(1)) {
			System.out.println("刪除成功");
		}else {
			System.out.println("刪除失敗");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
