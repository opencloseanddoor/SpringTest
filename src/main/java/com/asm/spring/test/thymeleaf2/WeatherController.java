package com.asm.spring.test.thymeleaf2;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.spring.test.thymeleaf2.service.WeatherService;
import com.asm.spring.test.thymeleaf2.weatherhistory.Weatherhistory;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherController 
{
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/list")
	public String weatherHistory(Model model)
	{
		//날씨 기록 리스트를 얻어 오기
		List<Weatherhistory> weather = weatherService.searchWeather(); //weather에는 날씨 정보 리스트가 들어있다.
		
		model.addAttribute("weather", weather);
		
		return "thymeleaf/weather/list";
	}
	
	@GetMapping("/input")
	public String weatherInput()
	{
		return "thymeleaf/weather/input";
	}
}
