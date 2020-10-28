package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.TruckBean;
import model.WorkerDao;

public class DemoWorkerAction {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		WorkerDao workDao1 = (WorkerDao) context.getBean("workerDao1");
		workDao1.printDetails();

		((ConfigurableApplicationContext) context).close();
	}

}
