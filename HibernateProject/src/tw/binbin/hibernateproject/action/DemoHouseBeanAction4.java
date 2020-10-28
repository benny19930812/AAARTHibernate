package tw.binbin.hibernateproject.action;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import tw.binbin.hibernateproject.model.HouseBean;
import tw.binbin.hibernateproject.util.HibernateUtil;

public class DemoHouseBeanAction4 {

	public static void main(String[] args) {
		//用HibernateUtil.getSessionFactory()取得factory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session sesseion = factory.getCurrentSession();
		try {
			sesseion.beginTransaction();
			HouseBean hBean = new HouseBean();
			hBean.setHouseid(1004);
			
			hBean.setHousename("trycatchSessionTEST!");
			
			sesseion.save(hBean);
			
			sesseion.getTransaction().commit();
			
		} catch (Exception e) {
			sesseion.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			System.out.println("Session closed");
			HibernateUtil.closeSessionFactory();
		}
	}

}
