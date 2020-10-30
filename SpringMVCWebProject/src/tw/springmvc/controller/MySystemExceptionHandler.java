package tw.springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MySystemExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public Object processExceptionHandle(Exception e) {
		String msg1 = "Error:Exception";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg1);
		
		
	}

}
