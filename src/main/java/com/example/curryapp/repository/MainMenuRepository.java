package com.example.curryapp.repository;

import com.example.curryapp.entity.MainMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainMenuRepository extends JpaRepository<MainMenu, Integer> {
}