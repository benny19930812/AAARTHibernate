package eeit124.group4._03_cultureAndCreativeShopsCMS.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import eeit124.group4._03_cultureAndCreativeShopsCMS.model.ShopBean;
import eeit124.group4._03_cultureAndCreativeShopsCMS.model.ShopBeanService;
import eeit124.group4.hibernateUtil.HibernateUtil;

public class DemoCreateShopsBeanByServiceAction0 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			ShopBean shopBean = new ShopBean();

//			shopBean.setShopId(101);
			shopBean.setName("小品雅集");
			shopBean.setRepresentImage("No Image Url");
			shopBean.setIntro("小品雅集成立於2008年，為推廣書寫，店內提供愛筆人士交流及服務。\r\n" + "鋼筆的特色在於可依個人喜好與習慣選擇不同外型、書寫效果及墨水等等。\r\n"
					+ "本公司為服務廣大客戶，經銷國內外各大品牌之商品，所販售的均為正版，絕無仿冒品，請放心選購。");
			shopBean.setCityName("台北市  大安區");

			shopBean.setAddress("106台北市大安區復興南路二段78巷76號一樓");
			shopBean.setLongitude(121.541190);
			shopBean.setLatitude(25.031089);
			shopBean.setOpenTime("週一至週六：中午 12:00 至晚上 10:00\r\n" + "週日：店休");
			shopBean.setPhone("02-2707-9737");

			shopBean.setFax("02-2707-9739");
			shopBean.setEmail("xiaopingtaipei@gmail.com");
			shopBean.setFacebook("https://www.facebook.com/xiaopingtaipei/");
			shopBean.setWebsite("https://www.tylee.tw/");
			shopBean.setClicks(1000);

			session.save(shopBean);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("商店資料新建失敗");

		} finally {
			// seseion.close();
			System.out.println("Session Closed");
			HibernateUtil.closeSessionFactory();
		}
	}
}
