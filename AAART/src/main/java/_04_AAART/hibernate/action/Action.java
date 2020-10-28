package _04_AAART.hibernate.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import _04_AAART.hibernate.model.ShowBean;
import _04_AAART.hibernate.model.ShowBeanDAO;
import _04_AAART.hibernate.model.ShowBeanService;
import hibernateweb.util.HibernateUtil;


public class Action {

public static void main(String[] args) {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	Session session = factory.getCurrentSession();
	System.out.println("here");
	try {
		session.beginTransaction();
		//調用Service service調用DAO DAO內寫好方法
		ShowBeanService SService = new ShowBeanService(session);
//		ShowBean showBean = SService.select(1000);	
//		System.out.println(showBean.getACT_NO()+":"+showBean.getACT_TITLE()+showBean.getACT_DESCRIPTION());
//		
//		//全部查詢
//		List<ShowBean> showlList = SService.selectAll();
//		for(ShowBean showBean2 : showlList) {
//			 System.out.println(showBean2.getACT_NO()+showBean2.getACT_TITLE());
//		}
		
		//模糊查詢
		String searchString;
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入搜尋關鍵字");
		searchString =scanner.next();
		//搜尋字傳入find()
		List<ShowBean> showlList = SService.find(searchString);
		for(ShowBean showBean2 : showlList) {
			 System.out.println(showBean2.getACT_NO()+": "+showBean2.getACT_TITLE());
		}

		session.getTransaction().commit();
	} catch (Exception e) {
		session.getTransaction().rollback();
		e.printStackTrace();
	}
	

	HibernateUtil.closeSessionFactory();
}


	
}
