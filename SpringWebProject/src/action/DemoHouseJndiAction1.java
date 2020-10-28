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

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.House;
import model.HouseDAO;

@WebServlet("/DemoHouseJndiAction1.do")
public class DemoHouseJndiAction1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext context;

	public void init() throws ServletException {
		//取得servletcontext
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
		try {
		    HouseDAO hDao = (HouseDAO)context.getBean("houseDao");		
			House hBean1 = hDao.select(1004);
			out.write(hBean1.getHouseid() + ":" + hBean1.getHousename() + "<br/>");			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		out.close();
		((ConfigurableApplicationContext)context).close();
	}

}
