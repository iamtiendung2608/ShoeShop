package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.database.PaymentRepo;
import com.example.demo.database.UserPayment;

@Controller
public class PaymentController {
	@Autowired
	PaymentRepo repo;
	@PostMapping("/payment")
	public String Payment(@ModelAttribute("payment")UserPayment payment) {
		return "Payment-page";
	}
	@PostMapping("/pay")
	public String Credit(@Valid @ModelAttribute("payment")UserPayment payment, BindingResult br
			,RedirectAttributes re) {
		if(br.hasErrors())
			return "Payment-page";
		else
		{
			System.out.println(payment);
			repo.save(payment);
			return "redirect:/addr";
		}
	}
}
