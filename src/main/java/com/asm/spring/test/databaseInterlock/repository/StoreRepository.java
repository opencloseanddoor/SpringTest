package com.asm.spring.test.databaseInterlock.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asm.spring.test.databaseInterlock.domain.Store;

//레포지토리는 쿼리를 통해서 필요한 기능을 만드는 것이다.
@Mapper // 순수하게 데이터베이스 쿼리수행 만을 수행한다
// Autowired를 통해서 객체를 생성을 할 수가 있다
public interface StoreRepository //인터페이스를 만들어 클래스의 규칙을 정한다 
{
	// store 테이블에 모든 행 조회
	//필요한 부분은 메소드명, 파라미터, 리턴타입
	public List<Store> selectedStoreList(); //이 메소드는 xml과 연동이 되어있는 파일이다
}