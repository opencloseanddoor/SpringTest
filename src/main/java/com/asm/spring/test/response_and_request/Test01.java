package com.asm.spring.test.response_and_request;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test01")
public class Test01 
{
	@RequestMapping("1")
	public String title()
	{
		String str = "<h1>테스트 프로젝트 완성</h1> <br> <h3>해당 프로젝트를 통해서 문제풀이를 진행합니다.";
		return str;
	}
	

	@RequestMapping("2")
	public Map<String, Integer> test02()
	{
		Map<String, Integer> score = new HashMap<>();
		
		score.put("국어", 80);
		score.put("수학", 90);
		score.put("영어", 85);
		return score;
	}
}
