package com.asm.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.test.mybatis.domain.RealEstate;
import com.asm.spring.test.mybatis.service.RealEstateService;

@Controller
public class RealEstateController 
{
	@Autowired
	private RealEstateService realEstateService;
	//id가 22인 페이지를 조회한다
	@RequestMapping("/mybatis/real-estate/1")
	@ResponseBody
	public RealEstate realEstate1(@RequestParam("id") int id)
	{
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@RequestMapping("/mybatis/real-estate/2")
	@ResponseBody
	public RealEstate realEstate2(@RequestParam("rentPrice") int rentPrice)
	{
		RealEstate realEstate = realEstateService.getRealEstate2(rentPrice);
		
		return realEstate;
	}
}
