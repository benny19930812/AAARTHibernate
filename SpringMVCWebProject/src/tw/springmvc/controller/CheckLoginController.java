package tw.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.springmvc.model.Account;
import tw.springmvc.model.AccountService;

@Controller
@SessionAttributes(names = {"user", "pwd"})//傳送至SESSION
public class CheckLoginController {
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(path = "/checkLogin.controller", method = RequestMethod.POST)
	public String processCheckLoginAction(@RequestParam(name = "userName") String userName, @RequestParam(name = "userPwd") String userPwd, Model m) {
        
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(userName==null || userName.length()==0) {
			errors.put("user", "username is required.");
        }
		
		if(userPwd==null || userPwd.length()==0) {
			errors.put("pwd", "user password is required.");
        }
		
		if(errors!=null && !errors.isEmpty()) {
			return "LoginSystem";
		}
		
		boolean status = accountService.checkLogin(new Account(userName, userPwd));
		m.addAttribute("user", userName);
		m.addAttribute("pwd", userPwd);
		
		if(status) {
			return "loginSuccess";
		}
		
		m.addAttribute("msg", "Your UserName or Password Is Not Correct.");
		return "LoginSystem";
	}
}
