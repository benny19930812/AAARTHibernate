package hibernateweb.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	//封裝SessionFactory factory
	private static SessionFactory factory = createSessionFactory();
	//封裝 factory createSessionFactory()方法
	private static SessionFactory createSessionFactory() {
		SessionFactory factory =null;
		try {
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
			return factory;
		}
	}
	//public取得factory
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	//public關閉factory
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
