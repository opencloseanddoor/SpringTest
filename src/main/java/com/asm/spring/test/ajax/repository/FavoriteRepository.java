package com.asm.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asm.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository 
{
	public List<Favorite> selectFavorite();
	
	public int insertFavorite
	(
		@Param("name") String name,
		@Param("url") String url
	);
	
	public int deleteFavorite(@Param("id") int id);
	
	public int isDuplicate(@Param("url") String url);
}
