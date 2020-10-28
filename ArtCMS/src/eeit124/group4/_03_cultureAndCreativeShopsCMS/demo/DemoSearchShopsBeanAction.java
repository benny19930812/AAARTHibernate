package eeit124.group4._03_cultureAndCreativeShopsCMS.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import eeit124.group4._03_cultureAndCreativeShopsCMS.model.ShopBean;
import eeit124.group4._03_cultureAndCreativeShopsCMS.model.ShopBeanService;
import eeit124.group4.hibernateUtil.HibernateUtil;

public class DemoSearchShopsBeanAction {

public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.getCurrentSession();
	
	try {
		session.beginTransaction();
		
		ShopBeanService sbs = new ShopBeanService(session);
		
//		ShopsBeanService.selectAll();
		
		Query<ShopBean> query = session.createQuery("From ShopsBean", ShopBean.class);
		List<ShopBean> list = query.list();
		
		for(ShopBean shop:list) {
			System.out.println(shop.getShopId()+ ":" + shop.getName());
		}
		
		session.getTransaction().commit();
		
	}catch (Exception e) {
		session.getTransaction().rollback();
		e.printStackTrace();
		
	}finally {
		//session.close();
		System.out.println("Session Closed");
		HibernateUtil.closeSessionFactory();
	}
	
	}


}
