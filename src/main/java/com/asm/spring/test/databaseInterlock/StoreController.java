package com.asm.spring.test.databaseInterlock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.test.databaseInterlock.domain.Store;
import com.asm.spring.test.databaseInterlock.service.StoreService;

@Controller //컨트롤러 생성
public class StoreController 
{
	@Autowired 
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> StoreList() // store의 변수들을 리스트로 갖고 있고 또 반환하는 클래스 생성
	{
		// 가게 정보 리스트를 json으로 reponse에 담는다
		// 가게 정보 리스트 얻어오기
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
	}
}	
