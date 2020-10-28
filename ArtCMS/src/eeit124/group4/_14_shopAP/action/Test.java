package eeit124.group4._14_shopAP.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import eeit124.group4._14_shopAP.model.ARTProduct;
import eeit124.group4.hibernateUtil.HibernateUtil;


public class Test {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		

		ARTProduct product = session.get(ARTProduct.class, "1601361978-445");
		
		System.out.println(product.getProductTitle());
		
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}

}
