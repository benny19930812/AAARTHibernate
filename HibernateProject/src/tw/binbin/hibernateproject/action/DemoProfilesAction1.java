package tw.binbin.hibernateproject.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.binbin.hibernateproject.model.Department;
import tw.binbin.hibernateproject.model.Profiles;
import tw.binbin.hibernateproject.util.HibernateUtil;



public class DemoProfilesAction1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();		
		Session session = factory.getCurrentSession();		
		
		session.beginTransaction();
		    
	    Query<Profiles> query = session.createQuery("From Profiles where username=:user and userpwd=:pwd", Profiles.class);	
	    query.setParameter("user", "mary");
	    query.setParameter("pwd", "123test");
	    
	    Profiles p1 = query.uniqueResult();
	    
	    if(p1!=null) {
	    	System.out.println("Login Success !!");
	    }else {
	    	System.out.println("username or password incorrect.");
	    }
		
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}


}
