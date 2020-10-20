package _04_AAART.hibernate.model;

import java.util.List;

import org.hibernate.Session;

public class ShowBeanService implements IShowBeanService {
	private ShowBeanDAO SDao;
	public ShowBeanService(Session session) {
		SDao = new ShowBeanDAO(session);
	}

	@Override
	public ShowBean insert(ShowBean bean) {		
		return SDao.insert(bean);
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
	public ShowBean update(int actid, String acttitle) {	
		return SDao.update(actid, acttitle);
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
