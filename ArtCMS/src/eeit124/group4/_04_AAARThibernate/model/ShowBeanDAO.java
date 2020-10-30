package eeit124.group4._04_AAARThibernate.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


@Repository("showBeanDao")
public class ShowBeanDAO {

	private Session session;

	public ShowBeanDAO(Session session) {
		this.session = session;
	}
//	//圖片新增(Blob)
//	public ShowBean Photoinsert(ShowBean showbean) throws IOException {
//		ShowBean picBean = session.get(ShowBean.class, showbean.getACT_NO());
//		File f = new File("assets/app.png");
//        //获得文件输入流
//        InputStream input = new FileInputStream(f);
//        //创建一个Blob对象
//        Blob image = (Blob) Hibernate.getLobCreator(session).createBlob(input, input.available());
//        //设置照片属性
//        picBean.setACT_PHOTO(image);
//        input.close();
//        session.save(picBean);
//		return picBean;
//    }


	// 新增
	public ShowBean insert(ShowBean showbean) {
		ShowBean resultBean = session.get(ShowBean.class, showbean.getACT_NO());

		if (resultBean == null) {
			session.save(showbean);
			return showbean;
		}
		return null;
	}

	// 查詢
	public ShowBean select(int actid) {
		return session.get(ShowBean.class, actid);
	}

	// 查詢多筆
	public List<ShowBean> selectAll() {
		// "From ShowBean"為createQuery
		//
		Query<ShowBean> query = session.createQuery("From ShowBean SB ORDER BY SB.ACT_NO", ShowBean.class);
		List<ShowBean> list = query.list();
		return list;
	}

	// 查詢多筆+分頁
	public List<ShowBean> selectAll2() {
		// "From ShowBean"為createQuery
		Query<ShowBean> query = session.createQuery("From ShowBean", ShowBean.class);
		query.setFirstResult(1);
		query.setMaxResults(100);
		List<ShowBean> list = query.list();
		return list;
	}

	// 修改
	public ShowBean update(int actno, String title, int category, String location, String locationName,
			String mainunit, String showunit, String description, String startdate, String enddate) {
		ShowBean showBean = session.get(ShowBean.class, actno);

		if (showBean != null) {
			showBean.setACT_TITLE(title);
			showBean.setACT_CATEGORY(category);
			showBean.setACT_LOCATION(locationName);
			showBean.setACT_MAINUNIT(mainunit);
			showBean.setACT_SHOWUNIT(showunit);
			showBean.setACT_DESCRIPTION(description);
			showBean.setACT_STARTDATE(startdate);
			showBean.setACT_ENDDATE(enddate);
		}

		return showBean;
	}

	// 刪除
	public boolean delete(int actid) {
		ShowBean result = session.get(ShowBean.class, actid);

		if (result != null) {
			session.delete(result);
			return true;
		}

		return false;
	}

	// 模糊查詢
	// find內預設傳入String searchString參數
	public List<ShowBean> find(String searchString) {
		String queryString = "from ShowBean where ACT_TITLE like'%" + searchString + "%'";
		Query queryObject = session.createQuery(queryString);

		return queryObject.list();

	}

}
