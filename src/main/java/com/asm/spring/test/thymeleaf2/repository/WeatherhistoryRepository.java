package com.asm.spring.test.thymeleaf2.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asm.spring.test.thymeleaf2.weatherhistory.Weatherhistory;

@Mapper
public interface WeatherhistoryRepository 
{
	//한 행의 정보를 담을 수 있는 리스트를 만들어 준다.
	public List<Weatherhistory> selectWeatherhistory();
	
	public int insertWeatherHistory(
			@Param("date") String date
			,@Param("weather") String weather
			,@Param("temperatures") double temperatures
			,@Param("precipitation") double precipitation
			,@Param("microDust") String microDust
			,@Param("windSpeed") double windSpeed);
}