package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.LoginDAO;
import model.LoginService;
import model.TruckBean;
import util.LogProvider;

public class DemoTruckBeanAction {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		TruckBean t1 =(TruckBean) context.getBean("truckBean");
		System.out.println("ID"+t1.getId());
		System.out.println("Brand"+t1.getBrand());
		
		TruckBean truck3 = (TruckBean)context.getBean("bmwTruck");
		System.out.println(truck3.getId() + ":" + truck3.getBrand());
		
		TruckBean truck4 = (TruckBean)context.getBean("mbenzTruck");
		System.out.println(truck4.getId() + ":" + truck4.getBrand());

		
		((ConfigurableApplicationContext)context).close();
	}
}
