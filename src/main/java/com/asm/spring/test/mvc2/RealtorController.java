package com.asm.spring.test.mvc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.spring.test.mvc2.domain.Realtor;
import com.asm.spring.test.mvc2.service.RealtorService;

@Controller
@RequestMapping("mvc2/realtor")
public class RealtorController 
{
	@Autowired
	RealtorService realtorService;

	@PostMapping("/create")
	public String createRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade
			, Model model)
	{
		Realtor realtor = new Realtor();
		
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		realtorService.addRealtor(realtor);
		model.addAttribute("result", realtor);
		
		return "mvc2/realtorInfo";
	}
	
	@RequestMapping("/input")
	public String realtorInput()
	{
		return "mvc2/realtorInput";
	}
	

	@RequestMapping("/info")
	public String realtorInfo()
	{
		return "mvc2/realtorInfo";
	}
}
