package hibernate.test.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ShowBeanDAO {

	private Session session;
	
	public ShowBeanDAO(Session session) {
		this.session =session;
	}
	//新增
	public ShowBean insert(ShowBean bean) {
		ShowBean resultBean = session.get(ShowBean.class,bean.getACT_NO());
		session.save(bean);
		return bean;
		
//		if (resultBean==null) {
//		}
//		return null;
	}
	//查詢
	public ShowBean select(int actid) {
		return session.get(ShowBean.class, actid);
	}
	
	//查詢多筆
	public List<ShowBean> selectAll() {
		Query<ShowBean> query = session.createQuery("From ShowBean", ShowBean.class);
		List<ShowBean> list = query.list();
		return list;
	}
	//修改
	public ShowBean update(int actid, String acttitle) {
		ShowBean result = session.get(ShowBean.class, acttitle);
		
		if(result!=null) {
			result.setACT_TITLE(acttitle);
		}
		
		return result;
	}
	//刪除
	public boolean delete(int actid) {
		ShowBean result = session.get(ShowBean.class, actid);
		
		if(result!=null) {
			session.delete(result);
			return true;
		}
		
		return false;
	}

}
