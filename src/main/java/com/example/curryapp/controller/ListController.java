package com.example.curryapp.controller;

import com.example.curryapp.entity.MainMenu;
import com.example.curryapp.repository.MainMenuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ListController {

    private final MainMenuRepository mainMenuRepository;

    public ListController(MainMenuRepository mainMenuRepository) {
        this.mainMenuRepository = mainMenuRepository;
    }

    @GetMapping("/list")
    public String showMenuList(Model model) {
        List<MainMenu> menuList = mainMenuRepository.findAll();
        model.addAttribute("menuList", menuList);
        return "products/list";
    }
}