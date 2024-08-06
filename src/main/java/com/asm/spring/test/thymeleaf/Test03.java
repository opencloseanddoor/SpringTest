package com.asm.spring.test.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03 	
{
	@RequestMapping("/thymeleaf/test03")
	public String thymeleaf() 
	{
		return "lifecycle/test03";
	}
}