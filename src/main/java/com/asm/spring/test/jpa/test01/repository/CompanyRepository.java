package com.asm.spring.test.jpa.test01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.spring.test.jpa.test01.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>
{
	//1행을 Insert
	
	
}
