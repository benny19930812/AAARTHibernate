package eeit124.group4._35_cms.model;

import java.util.List;

import org.hibernate.Session;

public class EventSpaceService implements InterfaceEventSpaceService {
	
	private EventSpaceDao dao;
	
	public EventSpaceService(Session session) {		
		dao = new EventSpaceDao(session);
	}
	
	@Override
	public EventSpace select(int id) {
		return dao.select(id);
	}
	
	@Override
	public List<EventSpace> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public EventSpace insert(EventSpace bean) {
		return dao.insert(bean);
	}

	@Override
	public EventSpace update(int id, String name) {
		return dao.update(id, name);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

}
