package eeit124.group4._18_course.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_LN")
public class Course_LN {
	private String id;
	private String title;
	private int act_Category;
	private String act_Location;
	private String location_Name;
	private String on_Sales;
	private int price;
	private String act_Time;
	private String end_Time;
	private String main_Unit;
	private String show_Unit;
	private String act_Comment;
	private String act_Description;
	private String act_Image;
	private String start_Date;
	private String end_Date;
	
//	public Course_LN() {
//		
//	}
//	
//	public Course_LN(String id, String title, int act_Category, String act_Location, String location_Name,
//			String on_Sales, int price, String act_Time, String end_Time, String main_Unit, String show_Unit,
//			String act_Comment, String act_Description, String act_Image, String start_Date, String end_Date) {
//		super();
//		this.Id = id;
//		this.Title = title;
//		this.Act_Category = act_Category;
//		this.Act_Location = act_Location;
//		this.Location_Name = location_Name;
//		this.On_Sales = on_Sales;
//		this.Price = price;
//		this.Act_Time = act_Time;
//		this.End_Time = end_Time;
//		this.Main_Unit = main_Unit;
//		this.Show_Unit = show_Unit;
//		this.Act_Comment = act_Comment;
//		this.Act_Description = act_Description;
//		this.Act_Image = act_Image;
//		this.Start_Date = start_Date;
//		this.End_Date = end_Date;
//	}
	

	@Id @Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getId() {
		return id;
	}
     
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "ACT_CATEGORY")
	public int getAct_Category() {
		return act_Category;
	}

	public void setAct_Category(int act_Category) {
		this.act_Category = act_Category;
	}
	
	@Column(name = "ACT_LOCATION")
	public String getAct_Location() {
		return act_Location;
	}

	public void setAct_Location(String act_Location) {
		this.act_Location = act_Location;
	}
	
	@Column(name = "LOCATION_NAME")
	public String getLocation_Name() {
		return location_Name;
	}

	public void setLocation_Name(String location_Name) {
		this.location_Name = location_Name;
	}
	
	@Column(name = "ON_SALES")
	public String getOn_Sales() {
		return on_Sales;
	}

	public void setOn_Sales(String on_Sales) {
		this.on_Sales = on_Sales;
	}
	
	@Column(name = "PRICE")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Column(name = "ACT_TIME")
	public String getAct_Time() {
		return act_Time;
	}

	public void setAct_Time(String act_Time) {
		this.act_Time = act_Time;
	}
	
	@Column(name = "END_TIME")
	public String getEnd_Time() {
		return end_Time;
	}

	public void setEnd_Time(String end_Time) {
		this.end_Time = end_Time;
	}
	
	@Column(name = "MAIN_UNIT")
	public String getMain_Unit() {
		return main_Unit;
	}

	public void setMain_Unit(String main_Unit) {
		this.main_Unit = main_Unit;
	}
	
	@Column(name = "SHOW_UNIT")
	public String getShow_Unit() {
		return show_Unit;
	}

	public void setShow_Unit(String show_Unit) {
		this.show_Unit = show_Unit;
	}
	
	@Column(name = "ACT_COMMENT")
	public String getAct_Comment() {
		return act_Comment;
	}

	public void setAct_Comment(String act_Comment) {
		this.act_Comment = act_Comment;
	}
	
	@Column(name = "ACT_DESCRIPTION")
	public String getAct_Description() {
		return act_Description;
	}

	public void setAct_Description(String act_Description) {
		this.act_Description = act_Description;
	}
	
	@Column(name = "ACT_IMAGE")
	public String getAct_Image() {
		return act_Image;
	}

	public void setAct_Image(String act_Image) {
		this.act_Image = act_Image;
	}
	
	@Column(name = "START_DATE")
	public String getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}
	
	@Column(name = "END_DATE")
	public String getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(String end_Date) {
		this.end_Date = end_Date;
	}

	
	
	
}
