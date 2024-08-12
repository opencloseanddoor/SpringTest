package com.asm.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.asm.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository 
{
	public int addSeller(Seller seller);
}
