package hibernate.test.action;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hibernate.test.model.ShowBean;
import hibernate.test.util.HibernateUtil;



public class Action2 {

	public static void main(String[] args) {
		//用HibernateUtil.getSessionFactory()取得factory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session sesseion = factory.openSession();
		sesseion.beginTransaction();
		
		ShowBean hBean = new ShowBean();
		hBean.setACT_NO(5000);
		
		hBean.setACT_TITLE("InsertTEST!");
		
		sesseion.save(hBean);
		
		sesseion.getTransaction().commit();
		sesseion.close();
		HibernateUtil.closeSessionFactory();		
	}

}
