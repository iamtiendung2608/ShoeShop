package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<UserAddress,Long>{
	
}
