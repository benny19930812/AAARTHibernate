package tw.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	@RequestMapping(path = "/except.controller")
	public void processionAction() throws Exception {
		throw new Exception();
	}
}
