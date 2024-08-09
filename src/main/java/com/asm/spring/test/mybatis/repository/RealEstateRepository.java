package com.asm.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asm.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository 
{
	public RealEstate selectRealEstate(@Param("id") int id);
	
	public RealEstate selectRealEstate2(@Param("rentPrice") int rentPrice);
	
	public RealEstate selectRealEstate3(@Param("area") int area, @Param("price") int price);
}