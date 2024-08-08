package com.asm.spring.test.databaseInterlock.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asm.spring.test.databaseInterlock.domain.Store;

@Mapper
public interface StoreRepository //인터페이스를 만들어 클래스의 규칙을 정한다 
{
	public List<Store> selectedStoreList(); //StoreRepository를 상속을 받는 클래스들은 이 메소드를 구현을 해야한다.
}
