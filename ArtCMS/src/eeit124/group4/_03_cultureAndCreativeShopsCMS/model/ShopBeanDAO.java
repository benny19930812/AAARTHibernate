package eeit124.group4._03_cultureAndCreativeShopsCMS.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


public class ShopBeanDAO {

	private Session session;

	public ShopBeanDAO(Session session) {
		this.session = session;
	}

	public boolean checkShopId(ShopBean bean) {
		ShopBean result = session.get(ShopBean.class, bean.getShopId());

		if (result != null) {
			return true;
		}
		return false;
	}

	public ShopBean insert(ShopBean bean) {
		ShopBean result = session.get(ShopBean.class, bean.getShopId());

		if (result == null) {
			session.save(bean);
			return bean;
		}
		return null;
	}

	public ShopBean select(int shopId) {
		return session.get(ShopBean.class, shopId);
		
	}

	public List<ShopBean> selectById(int shopId) {
		Query<ShopBean> query = session.createQuery("From ShopBean where shopId = " + shopId + " ", ShopBean.class);
		List<ShopBean> list = query.list();
		return list;
	}
	
	public List<ShopBean> selectByName(String name) {
		Query<ShopBean> query = session.createQuery("From ShopBean where name like '%" + name + "%' ", ShopBean.class);
		List<ShopBean> list = query.list();
		return list;
	}

	public List<ShopBean> selectAll() {
		Query<ShopBean> query = session.createQuery("From ShopBean", ShopBean.class);
		List<ShopBean> list = query.list();
		return list;
	}

	public ShopBean update(int shopId, String name, String representImage, String intro, String cityName,
			String address, Double longitude, Double latitude, String openTime, String phone, String fax, String email,
			String facebook, String website, int clicks) {

		ShopBean result = session.get(ShopBean.class, shopId);
		if (result != null) {
			result.setName(name);
			result.setRepresentImage(representImage);
			result.setIntro(intro);
			result.setCityName(cityName);

			result.setAddress(address);
			result.setLongitude(longitude);
			result.setLatitude(latitude);
			result.setOpenTime(openTime);
			result.setPhone(phone);

			result.setFax(fax);
			result.setEmail(email);
			result.setFacebook(facebook);
			result.setWebsite(website);
			result.setClicks(clicks);
		}
		return result;
	}

	public boolean delete(int shopId) {
		ShopBean result = session.get(ShopBean.class, shopId);

		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

}
