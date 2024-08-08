package com.asm.spring.test.databaseInterlock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.test.databaseInterlock.domain.Store;
import com.asm.spring.test.databaseInterlock.service.StoreService;

@Controller
public class StoreController 
{
	@Autowired 
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> StoreList()
	{
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
	}
}	
