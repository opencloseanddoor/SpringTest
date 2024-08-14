package com.asm.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asm.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository 
{
	// 닉네임, 매너온도, 프로필 이미지 경로를 전달 받고 한 행을 저장을 합니다
	public int insertSeller(
			@Param("nickName") String nickName
			, @Param("temperature") double temperature
			, @Param("profileImage") String profileImage);
	
	public Seller searchLastUser();
	
	public Seller selectSeller(@Param("id") int id);
}
