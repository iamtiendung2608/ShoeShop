package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepo extends JpaRepository<ItemsDetails,Integer> {
	
}
