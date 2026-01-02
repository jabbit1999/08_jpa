package com.beyond.springdatajpa.menu.controller;

import com.beyond.springdatajpa.menu.dto.MenuDTO;
import com.beyond.springdatajpa.menu.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

	private final MenuService menuService;
	
	public MenuController(MenuService menuSerivce) {
		this.menuService = menuSerivce;
	}
	
	@GetMapping("/{menuCode}")
	public String findMenuByCode(@PathVariable int menuCode, Model model) {
		
		MenuDTO menu = menuService.findMenuByCode(menuCode);
		
		model.addAttribute("menu", menu);
		
		return "menu/detail";
	}
}