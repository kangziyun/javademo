package com.skishop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mailaddress=" + mailaddress + ", password=" + password + "]";
	}
	@Id
	private int id ;
	private String name;
	private String mailaddress;
	private String password;
	private String img;
	private String address;
//	private Set orderSet = new HashSet<Order>();
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public String getMailaddress() {
		return mailaddress;
	}
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//    @OneToMany(mappedBy="user", targetEntity=Order.class, 
//            cascade=CascadeType.ALL)
//	public Set getOrderSet() {
//		return orderSet;
//	}
//	public void setOrderSet(Set orderSet) {
//		this.orderSet = orderSet;
//	}
	
	
}
