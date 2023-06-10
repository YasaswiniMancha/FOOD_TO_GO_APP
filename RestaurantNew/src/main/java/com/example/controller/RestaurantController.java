package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.MenuItem;
import com.example.entity.Restaurant;
import com.example.exceptionhandling.MenuItemException;
import com.example.exceptionhandling.RestaurantException;
import com.example.service.RestaurantServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController 
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantServiceImpl restaurantServiceImpl;
	
	
	@GetMapping("/{restaurantName}")        //working
    public List<Restaurant> findRestaurant(@PathVariable("restaurantName") String restaurantName) throws RestaurantException {
		List<Restaurant> restaurant = restaurantServiceImpl.searchRestaurantByName(restaurantName);
		if (restaurant == null) {
			throw new RestaurantException("No restaurant found with name: " + restaurantName);
		}
		return restaurant;
    }
	

    @GetMapping("/view/{restaurantId}")
    public Restaurant getByRestaurantId(@PathVariable Integer restaurantId) throws RestaurantException {
		Restaurant restaurant = restaurantServiceImpl.viewRestaurant(restaurantId);
		if (restaurant == null) {
			throw new RestaurantException("No restaurant found with id: " + restaurantId);
		}
		return restaurant;
    }    
    @GetMapping("/viewall")
	public List<Restaurant> getAllRestaurants() throws RestaurantException {
		List<Restaurant> restaurants = restaurantServiceImpl.viewAllRestaurants();
		if (restaurants.isEmpty()) {
			throw new RestaurantException("No restaurants found.");
		}
		return restaurants;
	}
	
}





