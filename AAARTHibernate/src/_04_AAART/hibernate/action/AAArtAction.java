package _04_AAART.hibernate.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _04_AAART.hibernate.model.ShowBean;
import _04_AAART.hibernate.model.ShowBeanDAO;
import _04_AAART.hibernate.model.ShowBeanService;
import hibernateweb.util.HibernateUtil;

/**
 * Servlet implementation class DemoHibernateAction1
 */
@WebServlet("/AAArtAction")
public class AAArtAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Map> list = new ArrayList<Map>();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		//用DAO物件帶入方法
//		ShowBeanDAO sDao = new ShowBeanDAO(session);
		//建service物件，用service帶入方法
		ShowBeanService showService = new ShowBeanService(session);
		List<ShowBean> showList = showService.selectAll();
		for (ShowBean showBean :showList ) {
			String category = Integer.toString(showBean.getACT_CATEGORY());
			int noint = showBean.getACT_NO();
			String titleString = showBean.getACT_TITLE();
			String siteString = showBean.getACT_LOCATION_NAME();
//			String description = showBean.getACT_DESCRIPTION();

			if (category.equals("1")) {
//				System.out.println(noint);
//				System.out.println(titleString);
//				System.out.println(siteString);
	
				Map map = new HashMap();
				map.put("no", noint);
				map.put("title", titleString);
				map.put("site", siteString);
//				map.put("description", description);
				// 存入map集合中
				System.out.println(map);
				list.add(map);// 將map集合放入list集合
//				System.out.println("放入集合");
				for (Map map_1 : list) {
					System.out.println(map_1);
				}

			}
		}
	}

}
