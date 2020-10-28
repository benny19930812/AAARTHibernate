package tw.binbin.hibernateproject.action;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import tw.binbin.hibernateproject.model.HouseBean;
import tw.binbin.hibernateproject.util.HibernateUtil;

public class DemoHouseBeanAction {

	public static void main(String[] args) {
		//用HibernateUtil.getSessionFactory()取得factory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session sesseion = factory.openSession();
		sesseion.beginTransaction();
		
		HouseBean hBean = new HouseBean();
		hBean.setHouseid(1002);
		
		hBean.setHousename("SessionFactoryTEST!");
		
		sesseion.save(hBean);
		
		sesseion.getTransaction().commit();
		sesseion.close();
		HibernateUtil.closeSessionFactory();		
	}

}
