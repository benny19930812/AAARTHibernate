package eeit124.group4._35_cms.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class EventSpaceDao {
	
	private Session session;
	
	public EventSpaceDao(Session session) {
		this.session = session;
	}
	
	//查詢單筆，傳入id
	public EventSpace select(int id) {
		return session.get(EventSpace.class, id);
	}
	
	//查詢全部
	public List<EventSpace> selectAll() {
		Query<EventSpace> query = session.createQuery("From EventSpace",EventSpace.class);
		List<EventSpace> list = query.list();
		return list;
	}
	
	//新增。存在就不新增，不存在才新增
	public EventSpace insert(EventSpace bean) {
		Query<EventSpace> query = session.createQuery("From EventSpace where name=:name",EventSpace.class);
		query.setParameter("name", bean.getName());
		List<EventSpace> result = query.list();
		
		if(result.size()==0) {
			session.save(bean);
			return bean;
		}
		return null;
	}
	
	//更新。傳入要更新的id和id對應的name
	public EventSpace update(int id, String name) {
		EventSpace result = session.get(EventSpace.class, id);
		if(result!=null) {
			result.setName(name);
		}
		return result;
	}
	
	//刪除。如果有傳入id對應的資料才刪除
	public boolean delete(int id) {
		EventSpace result = session.get(EventSpace.class, id);
		if(result!=null) {
			session.delete(result);
			return true;
		}
		return false;
	}
}
