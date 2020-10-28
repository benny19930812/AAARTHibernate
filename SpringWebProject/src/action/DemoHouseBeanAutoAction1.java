package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.HelloBean;
import model.HouseBean;
import model.HouseBeanDAO;

/**
 * Servlet implementation class DemoHouseBeanAutoAction1
 */
@WebServlet("/DemoHouseBeanAutoAction1")
public class DemoHouseBeanAutoAction1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext context;
	
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		context =WebApplicationContextUtils.getRequiredWebApplicationContext(application);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}
	private void processAction (HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HouseBeanDAO hDao1 =(HouseBeanDAO) context.getBean("houseBeanDao");
	
		HouseBean hBean1 =hDao1.select(1005);
		
		if(hBean1!=null) {
			   out.write(hBean1.getHouseid() + ":" + hBean1.getHousename() + "<br/>");
			}else {
				out.write("No Result.");
			}
			
			out.close();
		
		
	}
	
	

}
