package _04_AAARThibernate.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import _04_AAARThibernate.model.ShowBean;
import _04_AAARThibernate.model.ShowBeanDAO;
import _04_AAARThibernate.model.ShowBeanService;

import org.hibernate.Hibernate;

import hibernateweb.util.HibernateUtil;

@WebServlet("/AAArtAction")
public class AAArtAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		processAction(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		processAction(request, response);
//	}
//
//	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Map> list = new ArrayList<Map>();

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		// 用DAO物件帶入方法
//		ShowBeanDAO sDao = new ShowBeanDAO(session);
//		List<ShowBean> showList = sDao.selectAll();
		// 建service物件，用service帶入方法
		ShowBeanService showService = new ShowBeanService(session);
		List<ShowBean> showList = showService.selectAll();
		for (ShowBean showBean : showList) {
			String category = Integer.toString(showBean.getACT_CATEGORY());
//			int category = showBean.getACT_CATEGORY();
			int noint = showBean.getACT_NO();
			String titleString = showBean.getACT_TITLE();
			String siteString = showBean.getACT_LOCATION_NAME();
//			String description = showBean.getACT_DESCRIPTION();
			String queryCate = "5";
			if (queryCate.equals(category)) {
//				System.out.println(noint);
//				System.out.println(titleString);
//				System.out.println(siteString);

				Map map = new HashMap();
				map.put("no", noint);
				map.put("title", titleString);
				map.put("site", siteString);
//				map.put("description", description);
				// 存入map集合中
//				System.out.println(map);
				list.add(map);// 將map集合放入list集合
//				for (Map map_1 : list) {
//					System.out.println(map_1);
//				}
//				System.out.println("放入集合");

//
//			
				String p = request.getParameter("page");
				int page;
				try {
				//當前頁數

				page = Integer.valueOf(p);
				} catch (NumberFormatException e) {
					page = 1;
				}
				//搜尋後總活動數
				int totalnum = list.size();
				System.out.println("共"+totalnum+"筆資料");
				//每頁顯示活動數
				int PerPage = 100;
				//總頁數
				int totalPages = totalnum % PerPage == 0 ? totalnum / PerPage : totalnum / PerPage ;
				//本頁起始使用者序號
				int beginIndex = (page - 1) * PerPage;
				//本頁末尾使用者序號的下一個
				int endIndex = beginIndex +PerPage;
				if (endIndex > totalnum)
					endIndex = totalnum;
				request.setAttribute("totalnum", totalnum);
				request.setAttribute("PerPage", PerPage);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("beginIndex", beginIndex);
				request.setAttribute("endIndex", endIndex);
				request.setAttribute("page", page);

//				response.sendRedirect("/04_AAART.hibernate/AAA.jsp");

//				session.getTransaction().commit();
				session.close();
				HibernateUtil.closeSessionFactory();

//				HttpSession session2 = request.getSession();
//				session2.setAttribute("key_list", list);
				request.setAttribute("key_list", list);// 将list放入request中	
			}
		}
		int listsize = list.size();
		System.out.println("共" + listsize + "筆資料");

		for (Map map_1 : list) {
			System.out.println(map_1);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("_04_AAARThibernate/index.jsp");
		dispatcher.forward(request, response);
//		request.getRequestDispatcher("/04_AAART.hibernate/AAA.jsp").forward(request, response);
//			System.out.println("here");
	}

}
