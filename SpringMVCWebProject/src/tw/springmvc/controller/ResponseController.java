package tw.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	
	@RequestMapping(path = "/responseBodyMessage.controller", method = RequestMethod.GET)
	public @ResponseBody String processResponseBody() {
		return "This Message is From responseBody.";
	}
	
	@RequestMapping(path = "/responseBodyCharset.controller", method = RequestMethod.GET)
	public @ResponseBody String processResponseBodyCharset() {
		return "This Message is From responseBody Charset(中文).";
	}
	
	@RequestMapping(path = "/responseBodyCharset2.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String processResponseBodyCharset2() {
		return "This Message is From responseBody Charset2(中文).";
	}
	
	@RequestMapping(path = "/responseStatusCode.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String>  processresponseStatusCode() {
		return new ResponseEntity<String>("Forbidden(403)",HttpStatus.FORBIDDEN);
	}
	//
	@RequestMapping(path = "/responseImage1.controller")
	public void processresponseImageResource(HttpServletRequest request,HttpServletResponse response) throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/pages/images/images01.jpg");
		IOUtils.copy(is1, response.getOutputStream());
	}
	
	@RequestMapping(path = "/responseImageReturn.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody byte[] processResponseImageReturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/pages/images/images01.jpg");
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		return IOUtils.toByteArray(is1);
	}
	
	
}
