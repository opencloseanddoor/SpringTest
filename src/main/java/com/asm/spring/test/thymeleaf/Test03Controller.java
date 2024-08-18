package com.asm.spring.test.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller
{
	@RequestMapping("/test03")
	public String thymeleaf() //이 메소드는 lifecycle의 test03.html의 주소를 반환을 한다
	{
		return "lifecycle/test03"; //html의 주소를 반환을 한다
	}
}