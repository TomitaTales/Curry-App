package com.example.curryapp.controller;

import com.example.curryapp.entity.MainMenu;
import com.example.curryapp.repository.MainMenuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final MainMenuRepository repo;

    public ProductController(MainMenuRepository repo) {
        this.repo = repo;
    }

    // 商品登録画面
    @GetMapping("/form")
    public String showForm() {
        return "products/form";
    }

    // 商品登録処理
    @PostMapping("/form")
    public String registerProduct(
            @RequestParam String name,
            @RequestParam Integer price,
            @RequestParam String genre,
            @RequestParam Integer spiciness,
            RedirectAttributes redirectAttributes
    ) {
        MainMenu menu = new MainMenu(name, price, genre, spiciness);
        repo.save(menu);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました");
        return "redirect:/products/form";
    }
}