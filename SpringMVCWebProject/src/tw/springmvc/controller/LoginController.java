package tw.springmvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping(path = "/login.controller", method = RequestMethod.POST)
	public  void checkLogin(@RequestParam(name = "userName") String user, @RequestParam(name = "userPwd") String pwd ,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
    	
    	String userName = request.getParameter("userName");
    	String userPwd = request.getParameter("userPwd");
    	
    	System.out.println("userName:" + userName);
    	System.out.println("userPwd:" + userPwd);
		System.out.println("user" + user);
		System.out.println("pwd" + pwd);

		if ("Jim".equalsIgnoreCase(user) && "test321".equalsIgnoreCase(pwd)) {
			System.out.println("Success!!");
			return;
		}
		System.out.println("Your UserName or Password is Not Correct");
	}
}
