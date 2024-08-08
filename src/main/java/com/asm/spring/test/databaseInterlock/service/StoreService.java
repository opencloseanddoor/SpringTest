package com.asm.spring.test.databaseInterlock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.test.databaseInterlock.domain.Store;
import com.asm.spring.test.databaseInterlock.repository.StoreRepository;

@Service
public class StoreService 
{
	//가게 정보를 담고있는 리스트 리턴 기능
	@Autowired //객체를 자동으로 생성을 합니다(다만 객체를 여러개 만들지는 않습니다)
	private StoreRepository storeRepository; //인터페이스인 storeRepository안에 있는 메소드를 사용을 하기 위해서 인터페이스 변수를 선언합니다 
	
	public List<Store> getStoreList() //리스트를 반환해주는 getStoreList를 만듭니다
	{
		//store 테이블의 모든행을 조회를 해야한다.
		List<Store> storeList = storeRepository.selectedStoreList(); //모든 행을 조회를 하여서 storeList에 대입을 한다.
		
		return storeList; //storeList를 반환을 합니다.
	}
}
