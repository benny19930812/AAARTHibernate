package hibernate.test.model;

import java.util.List;

import org.hibernate.Session;

public class ShowBeanService implements IShowBeanService {
	private ShowBeanDAO hDao;
	public ShowBeanService(Session session) {
		hDao = new ShowBeanDAO(session);
	}

	@Override
	public ShowBean insert(ShowBean bean) {		
		return hDao.insert(bean);
	}

	@Override
	public ShowBean select(int actId) {		
		return hDao.select(actId);
	}

	@Override
	public List<ShowBean> selectAll() {	
		return hDao.selectAll();
	}

	@Override
	public ShowBean update(int actid, String acttitle) {	
		return hDao.update(actid, acttitle);
	}

	@Override
	public boolean delete(int actid) {	
		return hDao.delete(actid);
	}

}
