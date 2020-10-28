package tw.binbin.hibernateproject.action;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.test.util.HibernateUtil;
import tw.binbin.hibernateproject.model.Stock;
import tw.binbin.hibernateproject.model.StockTransaction;

public class DemoOneToManyMappingAction1 {

	public static void main(String[] args) {

	SessionFactory factory = HibernateUtil.getSessionFactory();	
	
	Session session =factory.getCurrentSession();
	try {
		session.beginTransaction();
		
		Stock stock =new Stock();
		stock.setStockname("台灣50");
		stock.setStockcode("0050");
		
		
		StockTransaction tran1 =new StockTransaction();
		StockTransaction tran2 =new StockTransaction();
		StockTransaction tran3 =new StockTransaction();
		
		tran1.setTradevolume(35000);
		tran2.setTradevolume(75000);
		tran3.setTradevolume(42000);
		//tran加入StockTransaction
		tran1.setStock(stock);
		tran2.setStock(stock);
		tran3.setStock(stock);
		
		Set<StockTransaction> trans =new HashSet<StockTransaction>();
		trans.add(tran1);
		trans.add(tran2);
		trans.add(tran3);
		//Stock加入tran
		stock.setStockTransaction(trans);
		//只儲存stock
		session.save(stock);
		
		session.getTransaction().commit();
	} catch (Exception e) {
		session.beginTransaction().rollback();
		e.printStackTrace();
	}finally {
		System.out.println("Session Closed");
		HibernateUtil.closeSessionFactory();
	}
	}

}
