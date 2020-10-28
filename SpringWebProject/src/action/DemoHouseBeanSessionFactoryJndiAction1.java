package action;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.HelloBean;
import model.House;
import model.HouseBean;
import model.HouseBeanDAO;
import model.HouseBeanService;
import model.HouseDAO;

@WebServlet("/DemoHouseBeanSessionFactoryJndiAction1")
public class DemoHouseBeanSessionFactoryJndiAction1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext context;

	public void init() throws ServletException {
        ServletContext application = getServletContext();
        context = WebApplicationContextUtils.getWebApplicationContext(application);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");		
		PrintWriter out = response.getWriter();
		
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory"); 
		Session session = sessionFactory.getCurrentSession();
		try {						
session.beginTransaction();
			
			HouseBean hBean1 = session.get(HouseBean.class, 1001);
			
			if(hBean1!=null) {
				out.println(hBean1.getHouseid() + ":" + hBean1.getHousename() + "<br/>");
			}
			
			HouseBeanDAO hDao2 = (HouseBeanDAO)context.getBean("houseBeanDao");
			HouseBean hBean2 = hDao2.select(1002);
			
			if(hBean2!=null) {
				out.println(hBean2.getHouseid() + ":" + hBean2.getHousename() + "<br/>");
			}
			
			HouseBeanService hService = (HouseBeanService)context.getBean("houseBeanService");
			HouseBean hBean3 = new HouseBean(1005, "Happy House");
			hService.insert(hBean3);			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}		
		
		out.close();
		((ConfigurableApplicationContext)context).close();
	}

}