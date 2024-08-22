package com.asm.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.test.ajax.domain.Favorite;
import com.asm.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService 
{
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> searchList()
	{
		List<Favorite> favoriteList = favoriteRepository.selectFavorite();
		
		return favoriteList;
	}
	
	public int insertList
	(
		String name,
		String address
	)
	{
		int count = favoriteRepository.insertFavorite(name, address);
		
		return count;
	}
}
