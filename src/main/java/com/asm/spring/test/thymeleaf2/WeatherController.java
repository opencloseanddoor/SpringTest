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
	
	@PostMapping("/input")
	public String weatherInput(
			@RequestParam("date") LocalDate date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("windSpeed") double windSpeed
			, Model model)
	{
		Weatherhistory weatherhis = new Weatherhistory();
		weatherhis.setDate(date);
		weatherhis.setWeather(weather);
		weatherhis.setTemperatures(temperatures);
		weatherhis.setPrecipitation(precipitation);
		weatherhis.setWindSpeed(windSpeed);
		
		model.addAttribute("waether", weatherhis);
		
		return "thymeleaf/weather/input";
	}
}
