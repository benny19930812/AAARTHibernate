package tw.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"name"})
public class ActionController {
	

	//Action導到的名稱
	@RequestMapping(path = "/action.controller")
	public  String processAction(Model m) {
		m.addAttribute("result", "happy day");
		return "resultPage";
	}
	
	@RequestMapping(path = "/myaction.controller")
	public  String processAction2(Model m) {
		m.addAttribute("result", "wonder hour");
		return "resultPage";
	}
}
