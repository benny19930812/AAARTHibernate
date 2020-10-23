package _04_AAARThibernate.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _04_AAARThibernate.model.ShowBean;
import _04_AAARThibernate.model.ShowBeanDAO;
import _04_AAARThibernate.model.ShowBeanService;
import hibernateweb.util.HibernateUtil;

public class InsertTest {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		ShowBeanService showService = new ShowBeanService(session);
		ShowBeanDAO showBeanDAO =new ShowBeanDAO(session);
		ShowBean hBean = new ShowBean();
		
		hBean.setACT_NO(5000);
		hBean.setACT_TITLE("1111");
		hBean.setACT_CATEGORY(2222);
		hBean.setACT_LOCATION("33333");
		hBean.setACT_MAINUNIT("4444");
		hBean.setACT_SHOWUNIT("showunit");
		hBean.setACT_DESCRIPTION("description");
		hBean.setACT_STARTDATE("startdate");
		hBean.setACT_ENDDATE("enddate");
		
//		showService.insert(hBean);
		showBeanDAO.insert(hBean);
		System.out.println("插入成功");
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();		

	}

}
