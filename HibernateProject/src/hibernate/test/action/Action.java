package hibernate.test.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import hibernate.test.model.ShowBean;
import hibernate.test.model.ShowBeanDAO;
import hibernate.test.model.ShowBeanService;
import hibernate.test.util.HibernateUtil;


public class Action {

public static void main(String[] args) {
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.getCurrentSession();
	System.out.println("here");
	try {
		session.beginTransaction();
		//調用Service service調用DAO DAO內寫好方法
		int cate= 1;
		ShowBeanService showService = new ShowBeanService(session);
//		ShowBean hBean = new ShowBean();
//		hBean.setACT_NO(5000);
//		hBean.setACT_TITLE("title");
//		hBean.setACT_NO(10);
		
	
		showService.insert(new ShowBean(5000,"white house"));
		
//		hBean.setACT_LOCATION(locationName);
//		hBean.setACT_MAINUNIT(mainunit);
//		hBean.setACT_SHOWUNIT(showunit);
//		hBean.setACT_DESCRIPTION(description);
//		hBean.setACT_STARTDATE(startdate);
//		hBean.setACT_ENDDATE(enddate);
//		session.save(hBean);
//		showService.insert(hBean);
		System.out.println("插入成功");
//		ShowBean hBean2 = showService.select(5000);	
//		System.out.println(hBean2.getACT_NO()+":"+hBean2.getACT_TITLE());
		session.getTransaction().commit();
		session.close();
//		HibernateUtil.closeSessionFactory();	
		
		
		
//		ShowBean hBean = SService.select(1000);	
//		System.out.println(hBean.getACT_NO()+":"+hBean.getACT_TITLE());
		
//		List<ShowBean> showlList = SService.selectAll();
//		for(ShowBean showBean : showlList) {
//			 System.out.println(showBean);
//		}
		
		

//		session.getTransaction().commit();
	} catch (Exception e) {
		session.getTransaction().rollback();
		e.printStackTrace();
	}
	

	HibernateUtil.closeSessionFactory();
}


	
}
