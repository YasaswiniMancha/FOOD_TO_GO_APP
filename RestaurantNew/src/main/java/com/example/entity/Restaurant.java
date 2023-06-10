package com.example.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "restaurantstablenew1")

public class Restaurant {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE)
      @Column(name="restaurantId")
	  private Integer id;
	  
	  private String restaurantName;
	  
	  private String restaurantImage;
	   
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantImage() {
		return restaurantImage;
	}
	public void setRestaurantImage(String restaurantImage) {
		this.restaurantImage = restaurantImage;
	}
	

	
}
