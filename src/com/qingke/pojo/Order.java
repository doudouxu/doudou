package com.qingke.pojo;

import java.util.Date;

public class Order {
   private Integer id;
   private String ordercode;
   private Integer user_id;
   private Integer product_id;
   private Double tolprice;
   private Date lasttime;
   private Integer number;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getOrdercode() {
	return ordercode;
}
public void setOrdercode(String ordercode) {
	this.ordercode = ordercode;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public Integer getProduct_id() {
	return product_id;
}
public void setProduct_id(Integer product_id) {
	this.product_id = product_id;
}
public Double getTolprice() {
	return tolprice;
}
public void setTolprice(Double tolprice) {
	this.tolprice = tolprice;
}
public Date getLasttime() {
	return lasttime;
}
public void setLasttime(Date lasttime) {
	this.lasttime = lasttime;
}
public Integer getNumber() {
	return number;
}
public void setNumber(Integer number) {
	this.number = number;
}
}
