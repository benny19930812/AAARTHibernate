package eeit124.group4._14_shopAP.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

	private int stockid;
	private String stockname;
	private String stockcode;
	private Set<StockTransaction> stockTransaction = new HashSet<StockTransaction>();

	@Id @Column(name = "STOCKID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	@Column(name = "STOCKNAME")
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	@Column(name = "STOCKCODE")
	public String getStockcode() {
		return stockcode;
	}
	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stock")
	public Set<StockTransaction> getStockTransaction() {
		return stockTransaction;
	}
	public void setStockTransaction(Set<StockTransaction> stockTransaction) {
		this.stockTransaction = stockTransaction;
	}

	
}
