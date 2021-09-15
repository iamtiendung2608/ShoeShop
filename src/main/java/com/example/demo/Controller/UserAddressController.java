package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.database.UserAddress;

@Controller
public class UserAddressController {
	@RequestMapping("/addr")
	public String AddAddress(@ModelAttribute("address")UserAddress address) {
		return "Address";
	}
	@PostMapping("/address")
	public String finish(@Valid @ModelAttribute("address")UserAddress address
			,BindingResult br) {
		if(br.hasErrors())
			return "Address";
		else {
			System.out.println(address);
			return "finish";
		}
	}
}



