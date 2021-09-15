package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@Autowired
	
	@RequestMapping("/cart")
	public String Cart() {
		return "Cart";
	}
}
