package aaart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class CRUDController {
	//Action導到的名稱
	
		@RequestMapping(path ="/SearchAll.controller", method = RequestMethod.POST)
	    public String processSearchAll() {
//			if (result.hasErrors()) {
//				return "MemberError";
//			}
//			m.addAttribute("memberName", members.getMemberName());
//			m.addAttribute("memberGender", members.getGender());
//			m.addAttribute("memberAge", members.getAge());
//		
			return "AAA";
	    }
		
		
		@RequestMapping(path = "/formEntry.controller", method = RequestMethod.GET)
		public String processEntryPage() {
			return "form";
		}
}
