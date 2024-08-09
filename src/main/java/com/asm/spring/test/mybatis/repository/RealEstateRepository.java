package com.asm.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asm.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository 
{
	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstate2(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectRealEstate3(@Param("area") int area, @Param("price") int price);

	public int insertByRealEstateObject(RealEstate realEstate);
	
	public int insertRealEstateByElement(@Param("realtorId") int realtorId
			,	@Param("address") String address
			,	@Param("area") int area
			,	@Param("type") String type
			,	@Param("price") int price
			,	@Param("rentPrice") int rentPrice);

}
