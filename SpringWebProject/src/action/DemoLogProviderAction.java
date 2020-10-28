package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.LogProvider;

public class DemoLogProviderAction {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		LogProvider p1 = (LogProvider) context.getBean("logProvider");
		LogProvider p2 =new LogProvider();
		p1.log("hola, amigo");
		p2.log("AAA, BBB");
		
		((ConfigurableApplicationContext)context).close();;
	}

}
