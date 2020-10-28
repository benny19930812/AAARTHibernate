package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.TestStringConstructorDI;
import model.TreeBean;

public class DemoBeanScopeAction {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		TestStringConstructorDI bean1 = (TestStringConstructorDI) context.getBean("msg1");
		TestStringConstructorDI bean2 = (TestStringConstructorDI) context.getBean("msg1");
		//預設singleton，同一物件
		System.out.println("code1: "+bean1.hashCode());
		System.out.println("code2: "+bean2.hashCode());
		
		((ConfigurableApplicationContext) context).close();
	}

}
