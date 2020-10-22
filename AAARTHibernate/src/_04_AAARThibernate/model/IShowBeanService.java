package _04_AAARThibernate.model;

import java.util.List;

public interface IShowBeanService {
	public ShowBean insert(ShowBean bean);
	public ShowBean select(int actId);
	public List<ShowBean> selectAll();
	public List<ShowBean> selectAll2();
	public ShowBean update(int actid, String acttitle);
	public boolean delete(int actid) ;
	public  List<ShowBean> find(String searchString);
}
