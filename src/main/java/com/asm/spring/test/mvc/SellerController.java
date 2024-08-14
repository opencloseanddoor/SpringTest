package com.asm.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.spring.test.mvc.domain.Seller;
import com.asm.spring.test.mvc.service.SellerService;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController 
{
	@Autowired
	SellerService sellerService;
	
	//데이터 저장 과정을 진행할 페이지
	@PostMapping("/create")
	public String createSeller(
			@RequestParam("nickName") String nickName
			, @RequestParam("temperature") double temperature
			, @RequestParam("profile") String profileImage)
	{
		
	    return "redirect:/mvc/seller/info";
	}
	
	@GetMapping("/input")
	public String sellerInput()
	{
		return "mvc/sellerInput";
	}
	
	@GetMapping("/info")
	public String sellerInfo(Model model, @RequestParam(value="id", required=false) Integer id)
	{
		Seller seller = null;
		
		//id가 전달이 안 되면 최근 판매자 조회
		if(id == null)
		{
			
			seller = sellerService.searchLastUser();
			
			model.addAttribute("seller", seller);
		}
		
		//id가 전달이 되면 매치된 판매자 조회
		else
		{
			seller = sellerService.getSeller(id);
			
			model.addAttribute("seller", seller);
		}
		
		return "mvc/sellerInfo";
	}
}
