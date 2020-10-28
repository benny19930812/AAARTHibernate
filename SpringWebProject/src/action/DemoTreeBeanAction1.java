package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.TreeBean;
import model.WorkerDao;

public class DemoTreeBeanAction1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		TreeBean treeaBean = (TreeBean) context.getBean("treeBean");
		System.out.println("Tree Name"+ treeaBean.getName());
		System.out.println("Tree age"+treeaBean.getAge());

		((ConfigurableApplicationContext) context).close();
	}

}
