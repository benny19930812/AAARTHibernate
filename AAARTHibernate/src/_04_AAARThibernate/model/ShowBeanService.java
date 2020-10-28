package _04_AAARThibernate.model;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

public class ShowBeanService implements IShowBeanService {
	private ShowBeanDAO SDao;
	public ShowBeanService(Session session) {
		SDao = new ShowBeanDAO(session);
	}

	@Override
	public ShowBean insert(ShowBean showbean) {		
		return SDao.insert(showbean);
	}

	@Override
	public ShowBean select(int actId) {		
		return SDao.select(actId);
	}

	@Override
	public List<ShowBean> selectAll() {	
		return SDao.selectAll();
	}
	
	@Override
	public List<ShowBean> selectAll2() {	
		return SDao.selectAll2();
	}

	@Override
	public ShowBean update(int actno, String title, int category, String location, String locationName,
			String mainunit, String showunit, String description, String startdate, String enddate) {	
		
		return SDao.update(actno,title,category,location,locationName,
				mainunit,showunit,description,startdate,enddate);
	}

	@Override
	public boolean delete(int actid) {	
		return SDao.delete(actid);
	}
	@Override
	public List<ShowBean> find(String searchString){
		return SDao.find(searchString);
	}

}
