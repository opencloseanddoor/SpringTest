package com.asm.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.test.mybatis.domain.RealEstate;
import com.asm.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/real-estate") // 중복된 코드를 허용하지 않게 하기 위해서 겹치는 경로는 클래스 위에 선언해놓았다.
public class RealEstateController 
{
	@Autowired
	private RealEstateService realEstateService;
	//id가 22인 페이지를 조회한다
	@RequestMapping("/1")
	@ResponseBody
	public RealEstate realEstate1(@RequestParam("id") int id)
	{
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public List<RealEstate> realEstate2(@RequestParam("rentPrice") int rentPrice)
	{
		List<RealEstate> realEstate = realEstateService.getRealEstate2(rentPrice);
		
		return realEstate;
	}
	
	@RequestMapping("/3")
	@ResponseBody
	public List<RealEstate> realEstate3(@RequestParam("area") int area, @RequestParam("price") int price)
	{
		List<RealEstate> realEstate = realEstateService.getRealEstate3(area, price);
		
		return realEstate;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String createRealEstate()
	{
		RealEstate realEstate = new RealEstate();
		
		realEstate.setRealtorId(2);
		realEstate.setAddress("서울시 서초구 양재동 다산빌딩");
		realEstate.setArea(80);
		realEstate.setType("매매");
		realEstate.setPrice(1);
		realEstate.setRentPrice(1);
		int count = realEstateService.addRealEstateByObject(realEstate);
		
		return "입력 갯수 : " + count;
	}
	
	@RequestMapping("/create2")
	@ResponseBody
	public String createRealEstate2()
	{
		int count = realEstateService.addRealEstateByElement(1, "서초구 양재동 양재빌딩", 50, "매매", 1, 1);
	
		return "입력 갯수 : " + count;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public int updateRealEstate(@RequestParam("id") int id)
	{
		RealEstate realEstate = new RealEstate();
		
		int count = realEstateService.updateRealEstateByObject(realEstate, id);
		
		return count;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	//이 메소드를 수행을 할 때는 id를 전달해주어야한다.
	public int deleteRealEstate(@RequestParam("id") int id)
	{
		RealEstate realEstate = new RealEstate(); //부동산 정보를 담고있는 객체를 생성을 한다.
		
		int count = realEstateService.deleteRealEstateByObject(realEstate, id); //서비스 클래스가 갖고있는 delete메소드를 객체와 변수를 인자로 하여서 실행한다.
		
		return count;
	}
}
