package eeit124.group4._03_cultureAndCreativeShopsCMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CS_CULTURE_AND_CREATIVE_SHOPS_TABLE")
public class ShopBean {
	
	@Id
	@Column(name = "SHOP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopId;	

	@Column(name = "NAME")
	private String name;	
	
	@Column(name = "REPRESENT_IMAGE")
	private String representImage;
	
	@Column(name = "INTRO")
	private String intro;
	
	@Column(name = "CITY_NAME")
	private String cityName;
	
	//=====================
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "LONGITUDE")
	private Double longitude;
	
	@Column(name = "LATITUDE")
	private Double latitude;
	
	@Column(name = "OPEN_TIME")
	private String openTime;
	
	@Column(name = "PHONE")
	private String phone;

	//==================
	
	@Column(name = "FAX")
	private String fax;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FACEBOOK")
	private String facebook;
	
	@Column(name = "WEBSITE")
	private String website;
	
	@Column(name = "CLICKS")
	private int clicks;
	
	//==================

//  舊建構子名稱並未完全修改
//	public ShopBean(int shopId, String name, String representImage, 
//			String intro, String cityName, String address, 
//			Double longitude, Double latitude, String openTime, 
//			String phone, String fax, String email, 
//			String facebook, String website, int clicks) {
//		
//		this.shopId=shopId;
//		this.name=name;
//		this.representImage=representImage;
//		this.intro=intro;
//		this.cityName=cityName;
//		
//		this.address=address;
//		this.longitude=longitude;
//		this.latitude=latitude;
//		this.openTime=openTime;
//		this.phone=phone;
//		
//		this.fax=fax;
//		this.email=email;
//		this.facebook=facebook;
//		this.website=website;
//		this.clicks=clicks;
//	}

	//==================
	
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRepresentImage() {
		return representImage;
	}

	public void setRepresentImage(String representImage) {
		this.representImage = representImage;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	
}
