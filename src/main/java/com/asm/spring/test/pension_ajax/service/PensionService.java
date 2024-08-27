package com.asm.spring.test.pension_ajax.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.test.pension_ajax.domain.Pension;
import com.asm.spring.test.pension_ajax.repository.PensionRepository;

@Service
public class PensionService
{
	@Autowired
	PensionRepository pensionRepository;
	
	public List<Pension> searchPension()
	{
		List<Pension> list = pensionRepository.selectRepository();
		
		return list;
	}
	
	public int deletePension
	(
		@Param("id") int id
	)
	{
		int count = pensionRepository.deleteList(id);
		
		return count;
	}
	
	public int createList
	(
		String name,
		LocalDate date,
		int day,
		int headcount,
		String phoneNumber
	)
	{
		int count = pensionRepository.createList(name, date, day, headcount, phoneNumber, "대기중");
		
		return count;
	}
	
	public Pension selectPension
	(
		String name,
		String phoneNumber
	)
	{
		return pensionRepository.selectPension(name, phoneNumber);
	}
}
