package hibernateweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //宣告此class為javabean
@Table(name = "DEPARTMENT")
public class Department {
	
	
	// 必須要有一個預設的建構方法
    // 以使得Hibernate可以使用Constructor.newInstance()建立物件
    public Department() {}
	
	
	@Id //設定primary key
	@Column(name = "DEPTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //primary key的產生方式 有auto、IDENTITY
	private int deptid;
	
	@Column(name = "DEPTNAME")
	private String deptname;
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}
