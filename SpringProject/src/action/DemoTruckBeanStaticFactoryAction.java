package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.TruckBean;

public class DemoTruckBeanStaticFactoryAction {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.config.xml");
		
		TruckBean truck1 = (TruckBean) context.getBean("toyotaTruck");
		System.out.println(truck1.getId()+":"+truck1.getBrand());
	
		TruckBean truck2 = (TruckBean) context.getBean("nissanTruck");
		System.out.println(truck2.getId()+":"+truck2.getBrand());
		
		((ConfigurableApplicationContext)context).close();
	
	}

}
