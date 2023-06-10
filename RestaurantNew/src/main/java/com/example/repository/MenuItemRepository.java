package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
	
 public   MenuItem getMenuItemById(Integer itemId);

	
	public Optional<MenuItem> findById(Integer itemId);
	
	public List<MenuItem> getByName(String name);
	
	@Query(value = "select * from itemstablenew1 where  RESTAURANT_ID= ?1", nativeQuery = true)

	public List<MenuItem> findByrestroId(Integer restaurantId);


	

}
