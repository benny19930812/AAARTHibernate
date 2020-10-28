package tw.binbin.hibernateproject.model;

import java.util.List;

public interface IHouseBeanService {
	public HouseBean insert(HouseBean bean);
	public HouseBean select(int houseId);
	public List<HouseBean> selectAll();
	public HouseBean update(int houseid, String houseName);
	public boolean delete(int houseid) ;
}
