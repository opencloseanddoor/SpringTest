package com.asm.spring.test.mvc2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.test.mvc2.domain.Realtor;
import com.asm.spring.test.mvc2.repository.RealtorRepository;

@Service
public class RealtorService 
{
	@Autowired
	RealtorRepository realtorRepository;
	
	public int addRealtor(Realtor Realtor)
	{
		int count = realtorRepository.insertRealtorByObject(Realtor);
		
		return count;
	}
}