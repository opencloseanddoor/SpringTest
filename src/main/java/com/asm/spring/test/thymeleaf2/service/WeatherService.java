package com.asm.spring.test.thymeleaf2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.spring.test.thymeleaf2.repository.WeatherhistoryRepository;
import com.asm.spring.test.thymeleaf2.weatherhistory.Weatherhistory;

@Service
public class WeatherService 
{
	@Autowired
	private WeatherhistoryRepository weatherhistoryRepository;
	
	public List<Weatherhistory> searchWeather()
	{
		List<Weatherhistory> weather = weatherhistoryRepository.selectWeatherhistory();
		
		return weather;
	}
	
	public int addWeather(
			  String date
			, String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed)
	{
		int count = weatherhistoryRepository.insertWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return count;
	}
	 
}
