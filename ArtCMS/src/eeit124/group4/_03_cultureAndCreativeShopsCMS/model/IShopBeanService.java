package eeit124.group4._03_cultureAndCreativeShopsCMS.model;

import java.util.List;

public interface IShopBeanService {
	public boolean checkShopId(ShopBean bean);
	public ShopBean insert(ShopBean bean);
	public List<ShopBean> selectById(int shopId);
	public List<ShopBean> selectByName(String name);
	public List<ShopBean> selectAll(); 
	public ShopBean update(int shopId, String name, String representImage, String intro, String cityName, 
			String address, Double longitude, Double latitude, String openTime, 
			String phone, String fax, String email, String facebook, String website, int clicks);
	public boolean delete(int shopId);
	
	
}
