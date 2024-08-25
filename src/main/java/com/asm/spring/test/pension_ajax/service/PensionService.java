package com.asm.spring.test.pension_ajax.service;

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
}
