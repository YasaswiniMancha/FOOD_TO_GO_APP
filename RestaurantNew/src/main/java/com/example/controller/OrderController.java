package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Order;
import com.example.exceptionhandling.OrdersException;
import com.example.service.OrderServiceImpl;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/orders")

public class OrderController {

	
    @Autowired
    private OrderServiceImpl orderServiceImpl;
    
    
    @PostMapping("/add")         //working    
    public Order saveorder(@RequestBody Order orders) throws OrdersException{
        orders.setOrderStatus("To be delivered");
        return orderServiceImpl.addOrder(orders);

    }
     
    @GetMapping(value = "/view/{orderId}")     //working
    public Order viewbyorderid(@PathVariable Integer orderId) throws OrdersException{
    	Order orderid= orderServiceImpl.viewOrder(orderId);
		if(orderid==null) {
			throw new OrdersException("No order found with id: " + orderid);
		}
		return orderid;
	}
    
    
    @GetMapping(value = "/viewallbyuserid/{id}")     //working
	public List<Order> getordersbyuserid(@PathVariable Integer id) throws OrdersException{

		return orderServiceImpl.vieworderbyuserid(id);
	}
    

    @GetMapping("/viewallbyrestroid/{restaurantId}")     //working
	public List<Order> getordersbyrestroid(@PathVariable Integer restaurantId) throws OrdersException{

		return orderServiceImpl.vieworderbyrestroid(restaurantId);
	}
    
    
    @PutMapping("/changestatus/{orderId}/status")                                      //working
    public ResponseEntity<Void> updateOrderStatus(@PathVariable Integer orderId, @RequestBody String orderStatus) throws OrdersException{
    	orderServiceImpl.updateOrderStatus(orderId, orderStatus);
        return ResponseEntity.ok().build();
    }
    
    
	@GetMapping( "/viewall")     //working
	public List<Order> getAllOrders() throws OrdersException{

		return orderServiceImpl.viewAllOrders();
	}
	
}
