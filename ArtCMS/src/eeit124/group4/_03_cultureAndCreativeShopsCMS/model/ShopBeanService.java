package eeit124.group4._03_cultureAndCreativeShopsCMS.model;

import java.util.List;

import org.hibernate.Session;

public class ShopBeanService implements IShopBeanService {

	private ShopBeanDAO shopBeanDAO;

	public ShopBeanService(Session session) {
		shopBeanDAO = new ShopBeanDAO(session);
	}
	
	@Override
	public boolean checkShopId(ShopBean bean) {
		return shopBeanDAO.checkShopId(bean);
	}
	
	@Override
	public ShopBean insert(ShopBean bean) {
		return shopBeanDAO.insert(bean);
	}

	@Override
	public List<ShopBean> selectById(int shopId) {
		return shopBeanDAO.selectById(shopId);
	}
	
	@Override
	public List<ShopBean> selectByName(String name) {
		return shopBeanDAO.selectByName(name);
	}

	@Override
	public List<ShopBean> selectAll() {
		return shopBeanDAO.selectAll();
	}

	@Override
	public ShopBean update(int shopId, String name, String representImage, String intro, String cityName,
			String address, Double longitude, Double latitude, String openTime, String phone, String fax, String email,
			String facebook, String website, int clicks) {

		return shopBeanDAO.update(shopId, name, representImage, intro, cityName, address, longitude, latitude,
				openTime, phone, fax, email, facebook, website, clicks);
	}

	@Override
	public boolean delete(int shopId) {
		return shopBeanDAO.delete(shopId);
	}

}
