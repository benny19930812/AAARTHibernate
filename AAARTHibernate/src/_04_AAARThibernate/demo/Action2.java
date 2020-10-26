package _04_AAARThibernate.demo;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import _04_AAARThibernate.model.ShowBean;
import hibernateweb.util.HibernateUtil;




public class Action2 {

	public static void main(String[] args) {
		//用HibernateUtil.getSessionFactory()取得factory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		ShowBean hBean = new ShowBean();
		hBean.setACT_NO(5000);
		
		hBean.setACT_TITLE("InsertTEST!");
		
		session.save(hBean);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();		
	}

}
