package com.asm.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.asm.spring.test.mvc.domain.Seller;
import com.asm.spring.test.mvc.service.SellerService;

@Controller
public class SellerController 
{
	@Autowired
	SellerService sellerService;
	
	@GetMapping("mvc/seller/info")
	//@RequestMapping("/mvc/seller/info")
	public int sellerInfo()
	{
		Seller seller = new Seller();
		
		seller.setNickName("안성민");
		
		
		int count = sellerService.addSeller(seller);
		
		//return "mvc/addSeller";
		return count;
	}
}
