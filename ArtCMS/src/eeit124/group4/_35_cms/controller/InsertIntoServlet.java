package eeit124.group4._35_cms.controller;

import java.io.IOException;
import java.time.LocalDate;

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

@WebServlet(name = "InsertInto", urlPatterns = "/_35_cms/InsertInto")
public class InsertIntoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		String name = (String)request.getParameter("name");
		String owner = (String)request.getParameter("owner");
		String address = (String)request.getParameter("address");
		String type = (String)request.getParameter("type");
		String shoppingArea = (String)request.getParameter("shoppingArea");
		String transportation = (String)request.getParameter("transportation");
		String strCapacity = (String)request.getParameter("capacity");
		Double capacity = null;
		try {
			capacity = Double.parseDouble(strCapacity);
		} catch (Exception e) {
			capacity = 0.0;
		}
		String strUnitPrice = (String)request.getParameter("unitPrice");
		Double unitPrice = null;
		try {
			unitPrice = Double.parseDouble(strUnitPrice);
		} catch (Exception e) {
			unitPrice = 0.0;
		}
		String strArea = (String)request.getParameter("area");
		Double area = null;
		try {
			area = Double.parseDouble(strArea);
		} catch (Exception e) {
			area = 0.0;
		}
		String strRentalTime = (String)request.getParameter("rentalTime");
		LocalDate rentalTime = null;
		try {
			rentalTime = LocalDate.parse(strRentalTime);
		} catch (Exception e) {
			LocalDate now=LocalDate.now();
			rentalTime = now;
		}
		String activityInfo = (String)request.getParameter("activityInfo");
		String contactInfo = (String)request.getParameter("contactInfo");

		EventSpace bean = new EventSpace(name,owner,address,type,shoppingArea,transportation,capacity,unitPrice,area,rentalTime,activityInfo,contactInfo);
		
		InterfaceEventSpaceService service = new EventSpaceService(session);
		EventSpace result = service.insert(bean);
		
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html;charset=UTF-8");
		if(result==null) {
			request.setAttribute("message", "該筆資料已存在，新增失敗");
		}else {
			request.setAttribute("message", "新增成功");
			request.setAttribute("eventSpace", result);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/_35_cms/insertResult.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
