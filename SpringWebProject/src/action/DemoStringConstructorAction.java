package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.LoginService;
import model.TestStringConstructorDI;


public class DemoStringConstructorAction {

	public static void main(String[] args) {
		//建立comtext 載入beans.config.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		//建立di1物件 來源自comtext.getBean("msg1")
		TestStringConstructorDI di1 = (TestStringConstructorDI)context.getBean("msg1");
		di1.showInfo();
		
		TestStringConstructorDI di2 = (TestStringConstructorDI)context.getBean("msg2");
		di2.showInfo();
		
		TestStringConstructorDI di3 = (TestStringConstructorDI)context.getBean("msg3");
		di3.showInfo();
		
		((ConfigurableApplicationContext)context).close();
	}

}
