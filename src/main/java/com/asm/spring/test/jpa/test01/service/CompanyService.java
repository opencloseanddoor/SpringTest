package com.asm.spring.test.jpa.test01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.test.jpa.test01.domain.Company;
import com.asm.spring.test.jpa.test01.repository.CompanyRepository;

@Service
public class CompanyService 
{
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany
	(
		String name,
		String business,
		String scale,
		int headcount
	)
	{
		Company company = Company.builder()
		.name(name)
		.business(business)
		.scale(scale)
		.headcount(headcount)
		.build();
				
		Company result = companyRepository.save(company);
		
		return result;
	}
	
	public Company updateCompany
	(
		int id,
		String scale,
		int headcount
	)
	{
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		Company company = optionalCompany.orElse(null); //null exception이 발생이 되면 null값을 리턴한다.
		
		company = company.toBuilder()
		.scale(scale)
		.headcount(headcount)
		.build();
		
		Company result = companyRepository.save(company);
		
		return result;
	}
	
	public void deleteCompany(int id)
	{
		// 삭제 대상을 조회 한다.
		// 조회된 객체를 통해서 삭제를 한다.
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
//		if(optionalCompany.isPresent()) //최종적으로 반환 된 값이 null이 아닌 경우
//		{
//			companyRepository.delete(optionalCompany.get()); //아래의 삭제 기능을 수행한다
//		}
		
		//null이 아닐 때 수행할 기능을 등록
		// c : optionalCompany 객체에 포함된 실제 객체
		optionalCompany.ifPresent(c -> companyRepository.delete(c));
	}
}
