package com.asm.spring.test.jpa.test01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.test.jpa.test01.domain.Company;
import com.asm.spring.test.jpa.test01.repository.CompanyRepository;
import com.asm.spring.test.jpa.test01.service.CompanyService;

@Controller
@RequestMapping("/jpa/test")
public class CompanyController 
{
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/create")
	@ResponseBody //@ResponseBody를 붙히지 않으면 html의 경로를 서버가 찾아서 반환한다, 그와 반대로 @ResponseBody를 붙히면 반환된 값을 문자열로 바꾸어서 반환한다
	public List<Company> createCompany()
	{
		Company company1 = companyService.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		Company company2 = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6834);
		
		List<Company> companyList = new ArrayList<>();
				
		companyList.add(company1);
		companyList.add(company2);
		
		return companyList;
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Company updateCompany()
	{
		Company company = companyService.updateCompany(8, "중소기업", 34);
		
		return company;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteCompany()
	{
		companyService.deleteCompany(11);
		
		return "Company 삭제 완료";
	}
}
