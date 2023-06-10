package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.entity.MenuItem;
import com.example.exceptionhandling.MenuItemException;


public interface MenuItemService {

	public MenuItem addItem(MenuItem menuitem) throws MenuItemException;

	
	public MenuItem viewItem(Integer id) throws MenuItemException;

	public List<MenuItem> viewAllItems() throws MenuItemException;
	
	public void deleteItem(Integer id) throws MenuItemException ;
	
	  public List<MenuItem> searchItemByName(String name)throws MenuItemException;
	  

		public List<MenuItem> viewItemsbyRestroid(Integer restaurantId) throws MenuItemException ;
		
		public  MenuItem updateMenuItem(Integer itemId, MenuItem menuItem)throws MenuItemException;
		
         

}