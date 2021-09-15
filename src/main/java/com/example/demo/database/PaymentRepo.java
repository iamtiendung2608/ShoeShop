package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository <UserPayment,Long> {

}
