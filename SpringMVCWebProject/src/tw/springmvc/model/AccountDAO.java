package tw.springmvc.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

//spring設定為DAO
@Repository("accountDao")
public class AccountDAO {
	//@Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFacory;
	
	@Autowired 
	public AccountDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}
	
	public boolean checkLogin(Account account) {
		Session session = sessionFacory.getCurrentSession();
		String hql = "from Account where username=:user and userpwd=:pwd";
		
		Query<Account> query = session.createQuery(hql, Account.class);
		query.setParameter("user", account.getUsername());
		query.setParameter("pwd", account.getUserpwd());
		
		Account resultAccount = query.uniqueResult();
		if(resultAccount!=null) {
			return true;
		}
		return false;
	}

}
