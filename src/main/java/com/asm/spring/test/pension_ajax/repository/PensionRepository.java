package com.asm.spring.test.pension_ajax.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asm.spring.test.pension_ajax.domain.Pension;

@Mapper
public interface PensionRepository 
{
	public List<Pension> selectRepository();
	
	public int deleteList(int id);
	
	public int createList
	(	
		@Param("name") String name,
		@Param("date") LocalDate date,
		@Param("day") int day,
		@Param("headcount") int headcount,
		@Param("phoneNumber") String phoneNumber,
		@Param("state") String state
	);
}