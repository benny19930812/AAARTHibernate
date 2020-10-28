package eeit124.group4._14_shopAP.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import eeit124.group4._14_shopAP.model.ARTProduct;
import eeit124.group4._14_shopAP.model.dao.ProductBeanDAOService;
import eeit124.group4.hibernateUtil.HibernateUtil;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {

	int pageNo = 0;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String function = request.getParameter("function");
		String productid = request.getParameter("productid");
		String apTitle = request.getParameter("APTITLE");
		String apPrice = request.getParameter("APPRICE");
		String apNum = request.getParameter("APNUM");
		System.out.println(function);

		if ("delete".equals(function)) {
//			SessionFactory factory = HibernateUtil.getFactory();
//			Session csession = factory.getCurrentSession();
			processDelete(productid, request, response);

		} else if ("create".equals(function)) {
			processCreate(apNum, apPrice, apTitle,  request, response);

		} else if ("update".equals(function)) {
			processUpdate(productid, request, response);

		} else if ("updateDone".equals(function)) {
			processUpdateDone(apNum, apPrice, apTitle, productid, request, response);

		} else {
//			SessionFactory factory = HibernateUtil.getFactory();
//			Session csession = factory.getCurrentSession();
			processAction(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	private void processUpdateDone(String apNum, String apPrice, String apTitle, String productid,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("processUpdateDone");
		HttpSession session = request.getSession(true);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session csession = factory.getCurrentSession();
		csession.beginTransaction();
		ProductBeanDAOService pDAO = new ProductBeanDAOService(csession);

		int num = Integer.parseInt(apNum);
		pDAO.update(productid, apTitle, apPrice, num);

		csession.getTransaction().commit();

		processAction(request, response);

	}

	private void processAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession(true);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session csession = factory.getCurrentSession();
		csession.beginTransaction();
		ProductBeanDAOService pDAO = new ProductBeanDAOService(csession);

		// 設定頁數
		try {
			String pageNoStr = request.getParameter("pageNo");
			if (pageNoStr == null) {
				pageNo = 1;
			} else {
				try {
					pageNo = Integer.parseInt(pageNoStr.trim());
				} catch (NumberFormatException e) {
					pageNo = 1;
				}
			}

			List<ARTProduct> pList = pDAO.selectAll(pageNo);
			int totalPage = pDAO.getTotalPages();
			csession.getTransaction().commit();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}

			request.setAttribute("pList", pList);
			session.setAttribute("pageNo", String.valueOf(pageNo));
			request.setAttribute("totalPages", totalPage);
			request.setAttribute("pages", totalPages);
			request.getRequestDispatcher("_14_shopAP/14_CRUDPage.jsp").forward(request, response);

			out.close();
		} catch (Exception e) {

		}
	}

	private void processCreate(String apNum, String apPrice, String apTitle, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("reall create");

		HttpSession session = request.getSession(true);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session csession = factory.getCurrentSession();
		csession.beginTransaction();
		int num = Integer.parseInt(apNum);
//		ProductBeanDAOService pDAO = new ProductBeanDAOService(csession);
		ARTProduct pd = new ARTProduct();
		pd.setProductTitle(apTitle);
		pd.setProductPrice(apPrice);
		pd.setProductNum(num);

		csession.save(pd);
		//		ARTProduct insert = pDAO.insert(pd);
//		if (insert == null) {
//			request.setAttribute("OrderErrorMessage", "此商品編號已被使用！");
//			csession.getTransaction().rollback();
//		} else {
			request.setAttribute("SuccessMessage", "商品新增成功！");
			csession.getTransaction().commit();
//		}

		processAction(request, response);

	}

	private void processDelete(String productid, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session csession = factory.getCurrentSession();
		csession.beginTransaction();
		ProductBeanDAOService pDAO = new ProductBeanDAOService(csession);

		boolean result = pDAO.delete(productid);
		if (result != false) {
			request.setAttribute("SuccessMessage", "編號 " + productid + " 的商品已刪除！");

		} else {
			request.setAttribute("OrderErrorMessage", "刪除失敗，請再次確認此商品狀態！");
//			csession.getTransaction().rollback();
		}

		List<ARTProduct> pList = pDAO.selectAll(pageNo);
		
			int totalPage = pDAO.getTotalPages();
			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}
			
			request.setAttribute("pList", pList);
			csession.getTransaction().commit();
			session.setAttribute("pageNo", String.valueOf(pageNo));
			request.setAttribute("totalPages", totalPage);
			request.setAttribute("pages", totalPages);
			request.getRequestDispatcher("_14_shopAP/14_CRUDPage.jsp").forward(request, response);

	}

	private void processUpdate(String productid, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Update");
		HttpSession session = request.getSession(true);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session csession = factory.getCurrentSession();
		csession.beginTransaction();
		ProductBeanDAOService pDAO = new ProductBeanDAOService(csession);
		ARTProduct ap = pDAO.select(productid);
		request.setAttribute("ap", ap);

		request.getRequestDispatcher("_14_shopAP/14_Update.jsp").forward(request, response);

	}

}
