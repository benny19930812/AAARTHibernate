package model;

import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloBean {
	private String name = "Benny";

	public HelloBean() {
	}
	
	public HelloBean(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println("hello," + name);
	}
}

