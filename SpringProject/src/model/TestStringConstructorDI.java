package model;

public class TestStringConstructorDI {
	
	private String name;
	
	//不帶參數建構子
	public TestStringConstructorDI() {
		
	}
	//set方法
	public void setName(String name) {
		this.name = name;
	}
	public TestStringConstructorDI(String name) {
		this.name = name;
	}

	public void showInfo() {
		System.out.printf("name=%s\n",name);
	}
	
	public void init() {
		System.out.println("init");
	}
	
	public void destory() {
		System.out.println("destory");
	}
}
