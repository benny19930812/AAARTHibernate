package eeit124.group4._35_cms.controller;

import java.io.IOException;
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

@WebServlet(name = "Update", urlPatterns = "/_35_cms/Update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		InterfaceEventSpaceService service = new EventSpaceService(session);
		EventSpace updateResult = service.update(20,"fsfdsfsdf");
		
		if(updateResult!=null) {
			System.out.println("name已更新:"+updateResult.getName());
		}else {
			System.out.println("沒有此筆資料，請再次確認");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
