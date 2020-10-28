package hibernate.test.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity  //宣告此class為javabean
@Table(name = "MAINTABLE")
public class ShowBean {
	

	@Id //設定primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //primary key的產生方式 有auto、IDENTITY	
	@Column(name = "ACT_NO")
	private int ACT_NO;
	
	@Column(name = "ACT_TITLE")
	private String ACT_TITLE;
	
	public ShowBean(int ACT_NO,String ACT_TITLE) {
		this.ACT_NO = ACT_NO;
		this.ACT_TITLE = ACT_TITLE;
		
	}
	
	
	public int getACT_NO() {
		return ACT_NO;
	}
	public void setACT_NO(int aCT_NO) {
		ACT_NO = aCT_NO;
	}
	public String getACT_TITLE() {
		return ACT_TITLE;
	}
	public void setACT_TITLE(String aCT_TITLE) {
		ACT_TITLE = aCT_TITLE;
	}
	


}
