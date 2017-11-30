package com.skishop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	private int id;
	private String name;
	private String description;
	private int price;
	private int discountprice;
	private String listimg;
	private String img1;
	private String img2;
	private String img3;
	private int producttypeid;
	private int hotproduct;
	private int newproduct;
	
	public int getHotproduct() {
		return hotproduct;
	}
	public void setHotproduct(int hotproduct) {
		this.hotproduct = hotproduct;
	}
	public int getNewproduct() {
		return newproduct;
	}
	public void setNewproduct(int newproduct) {
		this.newproduct = newproduct;
	}
	public int getProducttypeid() {
		return producttypeid;
	}
	public void setProducttypeid(int producttypeid) {
		this.producttypeid = producttypeid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getListimg() {
		return listimg;
	}
	public void setListimg(String listimg) {
		this.listimg = listimg;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(int discountprice) {
		this.discountprice = discountprice;
	}

	
}
