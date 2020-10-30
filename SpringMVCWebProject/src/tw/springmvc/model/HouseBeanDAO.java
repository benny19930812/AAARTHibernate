package tw.springmvc.model;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
public class HouseBeanDAO {

	private SessionFactory sessionFactory;

	public HouseBeanDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//新增
	public HouseBean insert(HouseBean bean) {
		Session session = sessionFactory.getCurrentSession();
		HouseBean resultBean = session.get(HouseBean.class,	bean.getHouseid());
		
		if (resultBean==null) {
			session.save(bean);
			return bean;
		}
		return null;
	}
	//查詢
	public HouseBean select(int houseId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(HouseBean.class, houseId);
	}
	
	//查詢多筆
	public List<HouseBean> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<HouseBean> query = session.createQuery("From HouseBean", HouseBean.class);
		List<HouseBean> list = query.list();
		return list;
	}
	//修改
	public HouseBean update(int houseid, String houseName) {
		Session session = sessionFactory.getCurrentSession();
		HouseBean result = session.get(HouseBean.class, houseid);
		
		if(result!=null) {
			result.setHousename(houseName);
		}
		
		return result;
	}
	//刪除
	public boolean delete(int houseid) {
		Session session = sessionFactory.getCurrentSession();
		HouseBean result = session.get(HouseBean.class, houseid);
		
		if(result!=null) {
			session.delete(result);
			return true;
		}
		
		return false;
	}
	
}
