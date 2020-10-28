package hibernateweb.action;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hibernateweb.model.HouseBean;
import hibernateweb.util.HibernateUtil;

public class DemoHouseBeanAction3 {

	public static void main(String[] args) {
		//用HibernateUtil.getSessionFactory()取得factory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session sesseion = factory.getCurrentSession();
		sesseion.beginTransaction();
		
		HouseBean hBean = new HouseBean();
		hBean.setHouseid(1003);
		
		hBean.setHousename("CurrentSessionTEST!");
		
		sesseion.save(hBean);
		
		sesseion.getTransaction().commit();
		sesseion.close();
		HibernateUtil.closeSessionFactory();		
	}

}
