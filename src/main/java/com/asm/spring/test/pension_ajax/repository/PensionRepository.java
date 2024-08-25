package com.asm.spring.test.pension_ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asm.spring.test.pension_ajax.domain.Pension;

@Mapper
public interface PensionRepository 
{
	public List<Pension> selectRepository();
	
	public int deleteList(int id);
}
