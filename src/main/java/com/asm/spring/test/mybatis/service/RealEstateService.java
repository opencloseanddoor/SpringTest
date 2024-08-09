package com.asm.spring.test.mybatis.service;

import java.util.List;

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

	public List<RealEstate> getRealEstate2(int rentPrice)
	{
		List<RealEstate> realEstate = realEstaraRepository.selectRealEstate2(rentPrice);
		
		return realEstate;
	}
	
	public List<RealEstate> getRealEstate3(int area, int price)
	{
		List<RealEstate> realEstate = realEstaraRepository.selectRealEstate3(area, price);
		
		return realEstate;
	}
	
	public int addRealEstateByObject(RealEstate realEstate)
	{
		int count = realEstaraRepository.insertByRealEstateObject(realEstate);
		
		return count;
	}
	
	public int addRealEstateByElement(int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice)
	{
		int count = realEstaraRepository.insertRealEstateByElement(realtorId, address, area, type, price, rentPrice);
		
		return count;
	}
}