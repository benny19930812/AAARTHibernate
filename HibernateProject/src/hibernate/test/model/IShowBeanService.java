package hibernate.test.model;

import java.util.List;

public interface IShowBeanService {
	public ShowBean insert(ShowBean bean);
	public ShowBean select(int actId);
	public List<ShowBean> selectAll();
	public ShowBean update(int actid, String acttitle);
	public boolean delete(int actid) ;
}
