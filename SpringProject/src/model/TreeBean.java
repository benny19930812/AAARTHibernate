package model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Scope("singleton")
public class TreeBean {

	@Value("#{props.name}")
	private String name;

	@Value("#{props.age}")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
