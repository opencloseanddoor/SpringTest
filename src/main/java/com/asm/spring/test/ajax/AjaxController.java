package com.asm.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.test.ajax.domain.Favorite;
import com.asm.spring.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax")
public class AjaxController
{
	
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/list")
	public String list(Model model)
	{
		List<Favorite> favorite = favoriteService.searchList();
		model.addAttribute("favorite", favorite);
		
		return "ajax/list";
	}
	
	@GetMapping("/input")
	public String input()
	{
		return "ajax/input";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createFavorite
	(
		@RequestParam("name") String name,
		@RequestParam("url") String url
	)
	{
		int count = favoriteService.insertList(name, url);
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1)
		{
			resultMap.put("result", "success");
		}
		else
		{
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteFavorite
	(
		@RequestParam("id") int id
	)
	{
		int count = favoriteService.deleteList(id);
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1)
		{
			resultMap.put("result", "success");
		}
		
		else 
		{
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("isDuplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicate
	(
		@RequestParam("url") String url
	)
	{
		// {"isDuplicate" : true}
		// {"isDuplicate" : false}
		Map<String, Boolean> isDuplicateMap = new HashMap<>();
		
		isDuplicateMap.put("isDuplicate", favoriteService.isDuplicate(url));
		
		return isDuplicateMap;
	}
}
