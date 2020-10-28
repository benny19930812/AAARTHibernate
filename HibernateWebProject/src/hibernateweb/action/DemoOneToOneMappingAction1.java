package hibernateweb.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import hibernateweb.model.Books;
import hibernateweb.model.BooksDetail;
import hibernateweb.util.HibernateUtil;

public class DemoOneToOneMappingAction1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	SessionFactory factory =HibernateUtil.getSessionFactory();
	
	Session session =factory.getCurrentSession();
	
	session.beginTransaction();
	
	Books books =new Books();
	books.setBooksname("Harry Potter");
	books.setAuthor("JK.Rowling");
	books.setPrice(450);
	
	BooksDetail booksDetail = new BooksDetail();
	booksDetail.setPublisher("Bloomsury");
	booksDetail.setPublisheraddress("UK");
	
	booksDetail.setBooks(books);
	books.setBooksDetail(booksDetail);
	
	session.save(books);
	
	session.getTransaction().commit();
	HibernateUtil.closeSessionFactory();
	
	}

}
