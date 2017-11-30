package com.skishop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {

	@Override
	public String toString() {
		return "Order [id=" + id + ", productid=" + productid + ", productcount=" + productcount + ", userid=" + userid + "]";
	}
	@Id
	private int id;
	private int productid;
	private int productcount;
	private int userid;
	private int admitsign;
	
	public int getAdmitsign() {
		return admitsign;
	}
	public void setAdmitsign(int admitsign) {
		this.admitsign = admitsign;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getProductcount() {
		return productcount;
	}
	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
