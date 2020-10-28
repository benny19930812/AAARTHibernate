package tw.binbin.hibernateproject.model;

import java.util.List;

import org.hibernate.Session;

public class HouseBeanService implements IHouseBeanService {
	private HouseBeanDAO hDao;
	public HouseBeanService(Session session) {
		hDao = new HouseBeanDAO(session);
	}

	@Override
	public HouseBean insert(HouseBean bean) {		
		return hDao.insert(bean);
	}

	@Override
	public HouseBean select(int houseId) {		
		return hDao.select(houseId);
	}

	@Override
	public List<HouseBean> selectAll() {	
		return hDao.selectAll();
	}

	@Override
	public HouseBean update(int houseid, String houseName) {	
		return hDao.update(houseid, houseName);
	}

	@Override
	public boolean delete(int houseid) {	
		return hDao.delete(houseid);
	}

}
