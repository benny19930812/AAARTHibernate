package tw.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oracle.net.aso.m;
import tw.springmvc.model.HouseBean;

@Controller
public class JsonCreatorController {
	@RequestMapping(path = "/houseBeanJson",method = RequestMethod.GET)
	public String processJson(Model model) {
		HouseBean hBean = new HouseBean();
		hBean.setHouseid(1001);
		hBean.setHousename("Funny House");
		model.addAttribute("houseBean",hBean);
		return "myhouseBean";
		
	}
}
