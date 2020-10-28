package tw.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		
		Map<String, String> errors = new HashMap<String,String>();
		request.setAttribute("errors", errors);
		
		if(user==null || user.length()==0) {
			errors.put("msg", "name is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {			
			return new ModelAndView("/form.jsp");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("name", user);
		return new ModelAndView("/success.jsp");
	}

}
