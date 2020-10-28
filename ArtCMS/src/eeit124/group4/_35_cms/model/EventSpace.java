package eeit124.group4._35_cms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EventSpace")
public class EventSpace {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="owner")
	private String owner;
	@Column(name="address")
	private String address;
	@Column(name="type")
	private String type;
	@Column(name="shoppingArea")
	private String shoppingArea;
	@Column(name="transportation")
	private String transportation;
	@Column(name="capacity")
	private double capacity;
	@Column(name="unitPrice")
	private double unitPrice;
	@Column(name="area")
	private double area;
	@Column(name="rentalTime")
	private LocalDate rentalTime;
	@Column(name="activityInfo")
	private String activityInfo;
	@Column(name="contactInfo")
	private String contactInfo;
	
	public EventSpace() {
		
	}
	
	public EventSpace(String name, String owner, String address, String type, String shoppingArea,
			String transportation, double capacity, double unitPrice, double area, LocalDate rentalTime,
			String activityInfo, String contactInfo) {
		this.name = name;
		this.owner = owner;
		this.address = address;
		this.type = type;
		this.shoppingArea = shoppingArea;
		this.transportation = transportation;
		this.capacity = capacity;
		this.unitPrice = unitPrice;
		this.area = area;
		this.rentalTime = rentalTime;
		this.activityInfo = activityInfo;
		this.contactInfo = contactInfo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getShoppingArea() {
		return shoppingArea;
	}
	public void setShoppingArea(String shoppingArea) {
		this.shoppingArea = shoppingArea;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public LocalDate getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(LocalDate rentalTime) {
		this.rentalTime = rentalTime;
	}
	public String getActivityInfo() {
		return activityInfo;
	}
	public void setActivityInfo(String activityInfo) {
		this.activityInfo = activityInfo;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
}
