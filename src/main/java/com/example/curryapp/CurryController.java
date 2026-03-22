package com.example.curryapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CurryController {

    private int total = 0;

    @GetMapping("/order")
    public String index() {
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam int menu) {
        total += menu;
        return "redirect:/";
    }

    @GetMapping("/total")
    @ResponseBody
    public String total() {
        return "合計：" + total + "円";
    }
}