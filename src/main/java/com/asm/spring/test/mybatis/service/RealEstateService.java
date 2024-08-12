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
	
	public int updateRealEstateByObject(int id)
	{
		int count = realEstaraRepository.updateRealEstateByObject(id);
		
		return count;
	}
	
	//RealEstate를 객체로하고 id도 정수형 매개변수로 하여서 전달을 받는 메소드를 작성을 한다.
	public int deleteRealEstateByObject(int id)
	{
		int count = realEstaraRepository.deleteRealEstateByObject(id); //이 메소드를 수행을 하면 성공한 쿼리문의 갯수 만큼을 리턴한다
		
		return count;
	}
}