package hibernateweb.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class SessionFactoryListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent scevent) {
		HibernateUtil.getSessionFactory();
		System.out.println("SessionFactory Created");
	}
	@Override
	public void contextDestroyed(ServletContextEvent  scevent) {
		HibernateUtil.closeSessionFactory();
		System.out.println("SessionFactory Closed");
	}
	
}
