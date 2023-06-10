package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.MenuItem;
import com.example.entity.Restaurant;
import com.example.exceptionhandling.MenuItemException;
import com.example.repository.MenuItemRepository;
import com.example.repository.RestaurantRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService {
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	
	@Override
	public MenuItem addItem(MenuItem menuitem) throws MenuItemException{
		
	    return menuItemRepository.save(menuitem);
	}
	
		
	@Override
    public MenuItem viewItem(Integer id) throws MenuItemException{

		Optional<MenuItem> item = menuItemRepository.findById(id);
		if(item.isPresent()) {
			return item.get();
		}else {
			throw new MenuItemException("Cannot find Item  with ID : " + id);
		}
    }

    @Override
    public List<MenuItem> viewAllItems() throws MenuItemException{

    	List<MenuItem> items = menuItemRepository.findAll();
		if(items.size() > 0) {
			
			return items;
			
		}else {
			
			throw new MenuItemException("Items are empty");
		}

    }

    @Override
    public void deleteItem(Integer id) throws MenuItemException {
        if (id == null) {
            throw new MenuItemException("Menu item id is null.");
        } else {
            menuItemRepository.deleteById(id);
        }
    }

	@Override
	public List<MenuItem> searchItemByName(String name) throws MenuItemException{
		
		  List<MenuItem> itemname = menuItemRepository.getByName(name);

	        return itemname; 
		
	}



	@Override
	public List<MenuItem> viewItemsbyRestroid(Integer restaurantId) throws MenuItemException{
		
		  try {
		        List<MenuItem> itemnames = menuItemRepository.findByrestroId(restaurantId);
		        return itemnames;
		    } catch (Exception e) {
		        throw new MenuItemException("Error viewing menu items by restaurant ID: " + e.getMessage());
		    }
	}


	 @Override
		    public MenuItem updateMenuItem(Integer id, MenuItem menuItem)throws MenuItemException {
		        MenuItem existingMenuItem = menuItemRepository.getMenuItemById(id);
		        existingMenuItem.setName(menuItem.getName());
		        existingMenuItem.setPrice(menuItem.getPrice());
		        existingMenuItem.setImageUrl(menuItem.getImageUrl());
		        existingMenuItem.setAvailability(menuItem.getAvailability());
		        return menuItemRepository.save(existingMenuItem);
		    }


	

	

}