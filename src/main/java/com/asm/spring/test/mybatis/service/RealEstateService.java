package com.asm.spring.test.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.test.mybatis.domain.RealEstate;
import com.asm.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService	
{
	@Autowired
	private RealEstateRepository realEstaraRepository;
	
	public RealEstate getRealEstate(int id)
	{
		RealEstate realEstate = realEstaraRepository.selectRealEstate(id);
		
		return realEstate;
	}

	public RealEstate getRealEstate2(int rentPrice)
	{
		RealEstate realEstate = realEstaraRepository.selectRealEstate2(rentPrice);
		
		return realEstate;
	}
	
	public RealEstate getRealEstate3(int area, int price)
	{
		RealEstate realEstate = realEstaraRepository.selectRealEstate3(area, price);
		
		return realEstate;
	}
}