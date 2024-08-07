package com.asm.spring.test.databaseInterlock.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asm.spring.test.databaseInterlock.domain.Store;

@Mapper
public interface StoreRepository 
{
	public List<Store> selectedStoreList();
}
