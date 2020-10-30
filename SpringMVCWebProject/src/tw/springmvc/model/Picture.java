package tw.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table(name = "Picture")
@Component
public class Picture {
	
	private int id;
	private String filename;
	private byte[]picture;
	
	public Picture() {
		
	}
	
	public Picture(int id,String filename,byte[]picture) {
		this.id = id;
		this.filename = filename;
		this.picture = picture;	
	}
	@Id @Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "FILENAME")
	public String getFilename() {
		return filename;
	}
	@Column(name = "")
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Column(name = "PICTURE")
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	

}
