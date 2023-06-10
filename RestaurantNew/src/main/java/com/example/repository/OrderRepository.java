package com.example.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	public Optional<Order> findById(Integer orderId);
	
	@Query(value = "select * from orderstablenew1 where  ID= ?1", nativeQuery = true)

	public List<Order> findByuserid(Integer id);
	
	@Query(value = "select * from orderstablenew1 where  RESTAURANT_ID= ?1", nativeQuery = true)

	public List<Order> findByrestroid(Integer restaurantId);
  
	@Transactional
	@Modifying
	@Query("UPDATE Order o SET o.orderStatus = :orderStatus WHERE o.orderId = :orderId")
	void updateOrderStatusByOrderId(@Param("orderId") Integer orderId, @Param("orderStatus") String orderStatus);




}
