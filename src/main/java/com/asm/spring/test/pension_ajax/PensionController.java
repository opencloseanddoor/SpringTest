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
	
	@GetMapping("/main")
	public String mainPage()
	{
		return "/pension/search";
	}
	
	@PostMapping("/search")
	@ResponseBody //내부적으로 객체를 문자열로 바꾸어주는 역할도 한다
	public Map<String, Object> searchList
	(
	    @RequestParam("name") String name,
	    @RequestParam("phoneNumber") String phoneNumber
	) 
	{
		Pension pension = pensionService.selectPension(name, phoneNumber); //조회된 리스트들을 반환 받아서 클래스 변수인 pension안에 반환 된 항목들을 집어넣습니다.
		Map<String, Object> resultMap = new HashMap<>();
		    
		if (pension != null) //펜션이라는 객체가 갖고있는 값이 null이 아니라면(객체변수 pension null이 들어있으면 페이지는 텅 비어있습니다)
		{
			resultMap.put("result", "success"); //맵안에 result라는 key와 success라는 값을 넣습니다.
		    resultMap.put("pension", pension); //맵안에 pension이라는 key와 pension이라는 객체를 추가합니다.
		} 
		else 
		{
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
}
