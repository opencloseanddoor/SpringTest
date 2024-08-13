package com.asm.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.test.mvc.domain.Seller;
import com.asm.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService
{
	@Autowired
	private SellerRepository sellerRepository;
	// 닉네임, 매너온도, 프로필 이미지 경로를 전달 받고 판매자 정보를 저장
	public int addSeller(
			String nickName,
			double temperature,
			String profileImage)
	{
		int count = sellerRepository.insertSeller(nickName, temperature, profileImage);
		
		return count;
	}
	
	public Seller serachLastUser()
	{
		Seller seller = sellerRepository.SearchLastUser();
		
		return seller;
	}
	
	public Seller getSeller(int id)
	{
		Seller seller = sellerRepository.selectSeller(id);
		
		return seller;
	}
}