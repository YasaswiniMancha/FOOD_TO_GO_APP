package com.example.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.MenuItem;
import com.example.entity.Order;
import com.example.exceptionhandling.OrdersException;
import com.example.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
 
	@Autowired
	private OrderRepository orderRepository;
	
	


	@Override
    public Order addOrder(Order orders) throws OrdersException{

        return orderRepository.save(orders);
    }
	


	@Override
    public Order viewOrder(Integer orderId)throws OrdersException {

		Optional<Order> order = orderRepository.findById(orderId);
		if(order.isPresent()) {
			return order.get();
			
		}else {
			throw new OrdersException("There is no order with id : " + orderId);
		}
    }
	
	

	@Override
	public List<Order> vieworderbyuserid(Integer id) throws OrdersException{
		
		 List<Order> ordersbyuser = orderRepository.findByuserid(id);

	        return ordersbyuser; 
		
	}
	
	

	@Override
	public List<Order> vieworderbyrestroid(Integer restaurantId) throws OrdersException {
		
		 if (orderRepository.findByrestroid(restaurantId) != null) {
		        List<Order> ordersbyrestro = orderRepository.findByrestroid(restaurantId);
		        return ordersbyrestro; 
		    } else {
		        throw new OrdersException("There is no order with restaurant id : " + restaurantId);
		    }
		}

	
	

	 @Transactional
	 @Override
	    public void updateOrderStatus(Integer orderId, String orderStatus) throws OrdersException {
	        orderRepository.updateOrderStatusByOrderId(orderId, orderStatus);
	    }
	 
	 

		@Override
		public List<Order> viewAllOrders() throws OrdersException {
		    if (!orderRepository.findAll().isEmpty()) {
		        List<Order> items = orderRepository.findAll();
		        return items;    
		    } else {
		        throw new OrdersException("There is no orders available");
		    }}
	
}
