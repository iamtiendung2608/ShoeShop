package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.database.CartItemsRepo;
import com.example.demo.database.ItemRepo;
import com.example.demo.database.Items;
import com.example.demo.database.ItemsDetails;
@Controller
public class ShopController {
	@Autowired
	ItemRepo repo;
	private CartItemsRepo CartRepo;
	public ShopController(CartItemsRepo cartRepo) {
		CartRepo = cartRepo;
	}
	List<Items>Product=Items.getImage();
	List<ItemsDetails>DetailsItems=ItemsDetails.getItems();
	List<ItemsDetails>UserCart=new ArrayList<ItemsDetails>();
	List<Integer>UserCartList=new ArrayList<Integer>();
	@RequestMapping("/shop")
	public String shoping(Model model) {
		model.addAttribute("Items", Product);
		for(Items i:Product) {
			repo.save(i);
			ItemsDetails Items1 =DetailsItems.get(i.getDetails()-1);
			Items1.setItem(i);
			Items1.setName();
			CartRepo.save(Items1);
		}
		return "shopping-page";
	}
	@GetMapping("/details/{id}")
	public String details(@PathVariable("id")int id, Model model) {
		ItemsDetails Items1 =CartRepo.findById(id).orElse(null);
		model.addAttribute("Items", Items1);
		//System.out.println(Items1);
		return "Show-Items";
	}
	@PostMapping("/details/{id}")
	public String AddtoCart(@PathVariable("id")int id) {
		ItemsDetails cardItems=CartRepo.findById(id).orElse(null);
		if(UserCartList.contains(id)) {
			UserCart.get(UserCartList.indexOf(id)).addNumber();
			UserCart.get(UserCartList.indexOf(id)).setTotal();
			UserCart.get(UserCartList.indexOf(id)).SubRemain();
		}
		else {
			cardItems.addNumber();
			cardItems.setTotal();
			cardItems.SubRemain();
			UserCart.add(cardItems);
			UserCartList.add(id);
		}
		for(int i=0;i<UserCart.size();i++) {
			System.out.println(UserCart.get(i));
		}
		return "redirect:/details/{id}";
	}
}





