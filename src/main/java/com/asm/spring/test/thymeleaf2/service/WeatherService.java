package com.asm.spring.test.thymeleaf2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public int insertWeather(Weatherhistory weather)
	{
		int count = weatherhistoryRepository.insertWeatherHistory(weather);
		
		return count;
	}
}
