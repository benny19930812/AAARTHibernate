package hibernateweb.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernateweb.model.HouseBean;
import hibernateweb.util.HibernateUtil;

public class DemoDbAction {

	private static Session session;
	
	
	public void processAction1() {
		// HouseBean hBean1 = session.load(HouseBean.class, 1005);
		HouseBean hBean1 = session.get(HouseBean.class, 1004);
		
		if(hBean1!=null) {
			System.out.println("House Id1: " + hBean1.getHouseid());
			System.out.println("House Name1: " + hBean1.getHousename());
		}else {
			System.out.println("No Data Found1.");
		}
		
	}
	public void processDelete(HouseBean hBean1) {
		session.delete(hBean1);
	}
	
	
	
	public void processAction2() {
		try{
			HouseBean hBean1 = session.load(HouseBean.class, 1002);	
		
			System.out.println("House Id2: " + hBean1.getHouseid());
			System.out.println("House Name2: " + hBean1.getHousename());
		}catch(Exception e) {
			System.out.println("No Data Found2.");
		}
		
	}
	
public void processQueryAll() {
		
		Query<HouseBean> query = session.createQuery("From HouseBean", HouseBean.class);
		List<HouseBean> list = query.list();
		
		for(HouseBean hBean:list) {
			System.out.println(hBean.getHouseid() + ":" + hBean.getHousename());
		}
	}
	
	
	
public static void main(String[] args) {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	session = factory.getCurrentSession();
	session.beginTransaction();
	
	DemoDbAction action1 = new DemoDbAction();
	//action1.processAction2();
//	action1.processQueryAll();
	action1.processDelete(new HouseBean(1001,"Tree House"));
	action1.processQueryAll();
	session.getTransaction().commit();
	HibernateUtil.closeSessionFactory();
}

	

	
	
}
