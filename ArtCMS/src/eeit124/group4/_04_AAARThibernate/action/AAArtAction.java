package eeit124.group4._04_AAARThibernate.action;

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

import eeit124.group4._04_AAARThibernate.model.ShowBean;
import eeit124.group4._04_AAARThibernate.model.ShowBeanDAO;
import eeit124.group4._04_AAARThibernate.model.ShowBeanService;

import org.hibernate.Hibernate;

import eeit124.group4.hibernateUtil.HibernateUtil;

@WebServlet("/AAArtAction")
public class AAArtAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Map> list = new ArrayList<Map>();

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			String queryCate = request.getParameter("category");

			ShowBeanService showService = new ShowBeanService(session);
			List<ShowBean> showList = showService.selectAll();
			for (ShowBean showBean : showList) {
				String category = Integer.toString(showBean.getACT_CATEGORY());

				int noint = showBean.getACT_NO();
				String titleString = showBean.getACT_TITLE();
				String siteString = showBean.getACT_LOCATION_NAME();

				if (queryCate.equals(category)) {

					Map map = new HashMap();
					map.put("no", noint);
					map.put("title", titleString);
					map.put("site", siteString);
					// 存入map集合中
				System.out.println(map);
					list.add(map);// 將map集合放入list集合
//				System.out.println("放入集合");
	
					String p = request.getParameter("page");
					int page;
					try {
						// 當前頁數

						page = Integer.valueOf(p);
					} catch (NumberFormatException e) {
						page = 1;
					}
					// 搜尋後總活動數
					int totalnum = list.size();
//				System.out.println("共"+totalnum+"筆資料");
					// 每頁顯示活動數
					int PerPage = 100;
					// 總頁數
					int totalPages = totalnum % PerPage == 0 ? totalnum / PerPage : totalnum / PerPage + 1;
					// 本頁起始使用者序號
					int beginIndex = (page - 1) * PerPage;
					// 本頁末尾使用者序號的下一個
					int endIndex = beginIndex + PerPage;
					if (endIndex > totalnum)
						endIndex = totalnum;
					request.setAttribute("totalnum", totalnum);
					request.setAttribute("PerPage", PerPage);
					request.setAttribute("totalPages", totalPages);
					request.setAttribute("beginIndex", beginIndex);
					request.setAttribute("endIndex", endIndex);
					request.setAttribute("page", page);
					request.setAttribute("category", queryCate);

					request.setAttribute("key_list", list);// 将list放入request中
				}
			}
			int listsize = list.size();
			System.out.println("共" + listsize + "筆資料");

//			for (Map map_1 : list) {
//				System.out.println(map_1);
//			}

		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("_04_AAARThibernate/index.jsp");
		dispatcher.forward(request, response);

	}

}
