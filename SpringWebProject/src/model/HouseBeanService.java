package model;

import java.util.List;

import org.hibernate.Session;

public class HouseBeanService  {
	
	private HouseBeanDAO hDao;
	
	public HouseBeanService(HouseBeanDAO hDao) {
		this.hDao=hDao;
	}


	public HouseBean insert(HouseBean bean) {		
		return hDao.insert(bean);
	}


	public HouseBean select(int houseId) {		
		return hDao.select(houseId);
	}


	public List<HouseBean> selectAll() {	
		return hDao.selectAll();
	}


	public HouseBean update(int houseid, String houseName) {	
		return hDao.update(houseid, houseName);
	}

	public boolean delete(int houseid) {	
		return hDao.delete(houseid);
	}

}
