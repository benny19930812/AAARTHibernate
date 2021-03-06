package tw.springmvc.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class PictureDAO {
	
	@Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Picture insert(Picture pBean) {
		Session session = sessionFactory.getCurrentSession();

		if (pBean != null) {
			session.save(pBean);
		}
		
		return pBean;
	}
	
	public Picture select(int id) {
		Session session = sessionFactory.getCurrentSession();
		Picture pBean = session.get(Picture.class, id);
		return pBean;
	}
}
