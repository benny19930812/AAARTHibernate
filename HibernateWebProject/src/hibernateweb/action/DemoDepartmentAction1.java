package hibernateweb.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernateweb.model.Department;
import hibernateweb.util.HibernateUtil;



public class DemoDepartmentAction1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();		
		Session session = factory.getCurrentSession();		
		
		session.beginTransaction();
		
		Query<Department> query = session.createQuery("From Department", Department.class);
		List<Department> list = query.list();
		
	    for(Department dept:list) {
	    	System.out.println(dept.getDeptid() + ":" + dept.getDeptname());
	    }	
	    
	    Query<Department> query1 = session.createQuery("From Department where Deptid=23", Department.class);
		Department dept1 =query1.uniqueResult();
		
		if(dept1!=null) {
			System.out.println(dept1.getDeptid()+dept1.getDeptname());
		}else {
			System.out.println("no result");
		}
	    
		
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}

}
