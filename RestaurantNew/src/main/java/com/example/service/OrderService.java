package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.entity.Order;
import com.example.exceptionhandling.OrdersException;


public interface OrderService {
	
	public Order viewOrder(Integer orderId)throws OrdersException;
	
	public Order addOrder(Order orders)throws OrdersException;
	
	public List<Order> vieworderbyuserid(Integer id) throws OrdersException;
	
	public List<Order> vieworderbyrestroid(Integer restaurantId) throws OrdersException;
	
	public void updateOrderStatus(Integer orderId, String orderStatus) throws OrdersException;
	
	public List<Order> viewAllOrders() throws OrdersException ;
	

}
