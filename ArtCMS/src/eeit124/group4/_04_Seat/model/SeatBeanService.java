package eeit124.group4._04_Seat.model;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

public class SeatBeanService implements ISeatBeanService {
	private SeatBeanDAO SDao;
	public SeatBeanService(Session session) {
		SDao = new SeatBeanDAO(session);
	}

	@Override
	public SeatBean insert(SeatBean SeatBean) {		
		return SDao.insert(SeatBean);
	}

//	@Override
//	public SeatBean select(int actId) {		
//		return SDao.select(actId);
//	}
//
//	@Override
//	public List<SeatBean> selectAll() {	
//		return SDao.selectAll();
//	}
//	
//	@Override
//	public List<SeatBean> selectAll2() {	
//		return SDao.selectAll2();
//	}
//
//	@Override
//	public SeatBean update(int actno, String title, int category, String location, String locationName,
//			String mainunit, String showunit, String description, String startdate, String enddate) {	
//		
//		return SDao.update(actno,title,category,location,locationName,
//				mainunit,showunit,description,startdate,enddate);
//	}
//
//	@Override
//	public boolean delete(int actid) {	
//		return SDao.delete(actid);
//	}
//	@Override
//	public List<SeatBean> find(String searchString){
//		return SDao.find(searchString);
//	}

}
