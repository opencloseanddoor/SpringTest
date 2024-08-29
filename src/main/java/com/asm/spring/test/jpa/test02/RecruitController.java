package com.asm.spring.test.jpa.test02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.test.jpa.test02.domain.Recruit;
import com.asm.spring.test.jpa.test02.repository.RecruitRepository;

//@RestController //@Controller + @ResponseBody
@Controller
@RequestMapping("/jpa/test2")
public class RecruitController 
{
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/find")
	@ResponseBody
	public List<Recruit> findRecruit()
	{
		List<Recruit> recruitList = null;
		
		//Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		//Recruit recruit = optionalRecruit.orElse(null);
		
		//recruitList = recruitRepository.findById(1);
		//recruitList = recruitRepository.findByCompanyId(2);
		
		//recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		
		//recruitList = recruitRepository.findByTypeOrderBySalaryDesc("계약직");
		
		//recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		//recruitList = recruitRepository.selectByList("2026-04-10", 8500);

		return recruitList;
	}
}
