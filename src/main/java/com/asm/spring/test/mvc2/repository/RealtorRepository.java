package com.asm.spring.test.mvc2.repository;

import org.apache.ibatis.annotations.Mapper;

import com.asm.spring.test.mvc2.domain.Realtor;

@Mapper
public interface RealtorRepository
{
	public int insertRealtorByObject(Realtor realtor);
}