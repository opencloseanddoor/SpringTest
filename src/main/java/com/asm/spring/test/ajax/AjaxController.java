package com.asm.spring.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.spring.test.ajax.domain.Favorite;
import com.asm.spring.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/")
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
	public String createFavorite
	(
		@RequestParam("name") String name,
		@RequestParam("address") String address
	)
	{
		int count = favoriteService.insertList(name, address);
		
		return "redirect:/ajax/list";
	}
}
