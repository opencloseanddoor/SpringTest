package com.asm.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.test.mvc.domain.Seller;
import com.asm.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService
{
	@Autowired
	SellerRepository sellerRepository;
	
	public int addSeller(Seller seller)
	{
		int count = sellerRepository.addSeller(seller);
		
		return count;
	}
}
