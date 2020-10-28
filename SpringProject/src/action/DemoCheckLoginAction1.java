package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.LoginDAO;
import util.LogProvider;

public class DemoCheckLoginAction1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		LoginDAO loginDao = (LoginDAO)context.getBean("loginDAO");
		boolean status = loginDao.checkLogin("john1", "test123");
		
		System.out.println("status:" + status);
		
		if(status) {
			System.out.println("login success !!");
		}else {
			System.out.println("please input correct username or password !!");
		}
		
		((ConfigurableApplicationContext)context).close();
	}
}
