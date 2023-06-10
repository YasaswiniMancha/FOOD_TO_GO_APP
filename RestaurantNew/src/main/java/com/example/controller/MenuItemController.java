package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.MenuItem;
import com.example.entity.Restaurant;
import com.example.exceptionhandling.MenuItemException;
import com.example.exceptionhandling.RestaurantException;
import com.example.service.MenuItemServiceImpl;
import com.example.service.RestaurantServiceImpl;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/items")
public class MenuItemController {

	@Autowired
	private MenuItemServiceImpl menuItemServiceImpl;
	
	@Autowired 
	private RestaurantServiceImpl restaurantService;
	
	
	
	@PutMapping("/update/{id}") //working
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Integer id, @RequestBody MenuItem menuItem) throws MenuItemException {
	    if (id == null || id <= 0) {
	        throw new MenuItemException("Invalid ID");
	    }
	    if (menuItem == null) {
	        throw new MenuItemException("Menu item cannot be null");
	    }
	    MenuItem updatedMenuItem = menuItemServiceImpl.updateMenuItem(id, menuItem);
	    return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
	}
	
	
	
	 @PostMapping("additem/{restaurantId}/menu") //working
	    public ResponseEntity<MenuItem> addMenuItem(@PathVariable Integer restaurantId,
	                                                 @RequestBody MenuItem menuItem) throws RestaurantException {
	        Restaurant restaurant = restaurantService.viewRestaurant(restaurantId);
	        menuItem.setRestaurant(restaurant);
	        MenuItem newMenuItem = restaurantService.addMenuItem(menuItem);
	        return new ResponseEntity<>(newMenuItem, HttpStatus.CREATED);
	    }

	
    
	@PostMapping("/add") //working
	public MenuItem addItem(@RequestBody MenuItem menuitem) throws MenuItemException  {
		
		return menuItemServiceImpl.addItem(menuitem);
		
	}


	@GetMapping("/view/{id}") //working
	public MenuItem getItem(@PathVariable Integer id) throws MenuItemException {
          MenuItem itemid= menuItemServiceImpl.viewItem(id);
		if(itemid==null) {
			throw new MenuItemException("No item found with id: " + id);
		}
		return itemid;
	}
	
	
	

	@GetMapping("/viewall") //working
	public List<MenuItem> getAllItems()  throws MenuItemException {
	    List<MenuItem> items = menuItemServiceImpl.viewAllItems();
	    if (items == null || items.isEmpty()) {
	        throw new MenuItemException("No items found");
	    }
	    return items;
	}


	
	@DeleteMapping("/delete/{id}") //working
	  public void deleteItem(@PathVariable Integer id ) throws MenuItemException {                  //working
		     
		menuItemServiceImpl.deleteItem(id);
		  
	  }
	
	
	
	
	@GetMapping("/{name}")        //working
    public List<MenuItem> findItem(@PathVariable("name") String name) throws MenuItemException {
		List<MenuItem> menuitem = menuItemServiceImpl.searchItemByName(name);
		if (menuitem == null) {
			throw new MenuItemException("No item found with name: " + name);
		}
		return menuitem;
    }
	
	
	
	@GetMapping("/viewallbyrestroid/{restaurantId}") //working
	public List<MenuItem> getItemsbyrestroid(@PathVariable Integer restaurantId) throws MenuItemException {
		List<MenuItem> items = null;
		if (restaurantId <= 0) { // if restaurantId is not valid
			throw new MenuItemException("Invalid restaurant ID");
		} else {
			try {
				items = menuItemServiceImpl.viewItemsbyRestroid(restaurantId);
			} catch (Exception e) {
				throw new MenuItemException("Error retrieving menu items");
			}
		}
		return items;
	}

	

	
}
