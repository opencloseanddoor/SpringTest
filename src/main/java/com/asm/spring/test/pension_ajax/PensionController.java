package com.asm.spring.test.pension_ajax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.test.pension_ajax.domain.Pension;
import com.asm.spring.test.pension_ajax.service.PensionService;

@Controller
@RequestMapping("/pension")
public class PensionController 
{
	@Autowired
	PensionService pensionService;
	
	@GetMapping("/list")
	public String list(Model model)
	{
		List<Pension> pension = pensionService.searchPension();
		model.addAttribute("pension", pension);
		
		return "/pension/list";
	}
	
	@GetMapping("/input")
	public String input()
	{
		return "/pension/input";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> delete
	(
		@RequestParam("id") int id
	)
	{
		int count = pensionService.deletePension(id);
		Map<String, String> result = new HashMap<>();
		
		if(count == 1)
		{
			result.put("result", "success");
		}
		
		else
		{
			result.put("result", "success");
		}
		return result;
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createPensionList
	(
		@RequestParam("name") String name,
		@RequestParam("date") @DateTimeFormat(pattern="yyyy년 M월 d일") LocalDate date,
		@RequestParam("day") int day,
		@RequestParam("headcount") int headcount,	
		@RequestParam("phoneNumber") String phoneNumber
	)
	{
		int count = pensionService.createList(name, date, day, headcount, phoneNumber);
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1)
		{
			resultMap.put("result", "success");
		}
		
		else
		{
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/search")
	public String searchList()
	{
		return "/pension/search";
	}
}
