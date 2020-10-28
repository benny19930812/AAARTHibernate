package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.TreeBean2;


public class DemoTreeBeanAction2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		TreeBean2 treeBean = (TreeBean2)context.getBean("tree");
		System.out.println("Tree Name2:" + treeBean.getName());
		System.out.println("Tree Age2:" + treeBean.getAge());
		
		((ConfigurableApplicationContext) context).close();
	}

}
