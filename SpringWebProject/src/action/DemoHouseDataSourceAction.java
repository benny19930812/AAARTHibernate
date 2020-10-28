package action;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.House;
import model.HouseDAO;
import model.HouseService;
import model.TruckBean;
import model.WorkerDao;

public class DemoHouseDataSourceAction {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		HouseDAO houseDAO = (HouseDAO) context.getBean("houseDao");
		House hBean1 =houseDAO.select(1001);
		System.out.println(hBean1.getHouseid()+": "+hBean1.getHousename());
		
		HouseService houseService = (HouseService) context.getBean("houseService");
		House hBean2 =houseService.select(1002);
		System.out.println(hBean2.getHouseid()+": "+hBean2.getHousename());
		
		((ConfigurableApplicationContext) context).close();
	}

}
