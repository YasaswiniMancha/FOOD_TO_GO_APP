package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orderstablenew1")

public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer orderId;
	
	private String orderStatus;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@ManyToOne
	@JoinColumn(name="itemId")		   
	private MenuItem menuitem;

	@ManyToOne
	@JoinColumn(name="restaurantId")		   
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name="id")		   
	private User user;

	public MenuItem getMenuitem() {
		return menuitem;
	}
	public void setMenuitem(MenuItem menuitem) {
		this.menuitem = menuitem;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
		
}
