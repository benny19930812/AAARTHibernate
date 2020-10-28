package eeit124.group4._14_shopAP.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import eeit124.group4._14_shopAP.model.ARTProduct;
import eeit124.group4._14_shopAP.model.dao.ProductBeanDAOImp;
import eeit124.group4.hibernateUtil.HibernateUtil;


public class TestProductDAO {

	public static void main(String[] args) {
		int pageNo=1;

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			ProductBeanDAOImp pDAO = new ProductBeanDAOImp(session);
			
			List<ARTProduct> selectAll = pDAO.selectAll(pageNo);
			Iterator<ARTProduct> il = selectAll.iterator();
			
			while(il.hasNext()) {
				ARTProduct pd = il.next();
				System.out.println(pd.getProductId()+" ： "+pd.getProductTitle());
			}
		session.getTransaction().commit();	
			
		} catch (Exception e) {

			session.getTransaction().rollback();
		}
		
		HibernateUtil.closeSessionFactory();
		
	}

}
