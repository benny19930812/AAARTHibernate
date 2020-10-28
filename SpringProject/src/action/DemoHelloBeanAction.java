package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.HelloBean;
import model.LoginDAO;
import model.LoginService;

public class DemoHelloBeanAction {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		//使用@
		HelloBean hBean = (HelloBean) context.getBean("helloBean");
		hBean.sayHello();
		//使用@
		LoginDAO loginDAO1 = (LoginDAO) context.getBean("loginDao1");
		boolean status = loginDAO1.checkLogin("john", "test123");
		System.out.println("status:" + status);
		//使用@
		LoginService loginService3 = (LoginService) context.getBean("loginService3");
		boolean status3 = loginDAO1.checkLogin("Marry", "test123");
		System.out.println("status:" + status3);
		
		((ConfigurableApplicationContext) context).close();

	}

}
