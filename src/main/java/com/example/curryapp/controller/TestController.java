package com.example.curryapp.controller;

import com.example.curryapp.entity.MainMenu;
import com.example.curryapp.repository.MainMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private MainMenuRepository repo;

    @GetMapping("/test")
    public String test() {

        MainMenu menu = new MainMenu("マークスカイカレー", 800, "牛肉", 3);
        repo.save(menu);

        return "保存完了";
    }
}