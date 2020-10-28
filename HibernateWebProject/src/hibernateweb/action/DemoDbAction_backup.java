package hibernateweb.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernateweb.model.HouseBean;
import hibernateweb.model.HouseBeanDAO;
import hibernateweb.util.HibernateUtil;

public class DemoDbAction_backup {

	private static Session session;
	
	
	
	
public static void main(String[] args) {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	session = factory.getCurrentSession();
	try {
		session.beginTransaction();
		
		HouseBeanDAO hDao =new HouseBeanDAO(session);
		hDao.insert(new HouseBean(1001,"white house"));
		
		List<HouseBean>list = hDao.selectAll();
		
		//Iterator
		Iterator<HouseBean> i1 =list.iterator();
		while (i1.hasNext()) {
			HouseBean hBean = i1.next();
			System.out.println(hBean.getHouseid()+":"+hBean.getHousename());
			
		}
		System.out.println("for方法");
		//for方法
		for(HouseBean hBean:list) {
			System.out.println(hBean.getHouseid() + ":" + hBean.getHousename());
		}
		session.getTransaction().commit();
	} catch (Exception e) {
		session.getTransaction().rollback();
		e.printStackTrace();
	}
	

	HibernateUtil.closeSessionFactory();
}

	

	
	
}
