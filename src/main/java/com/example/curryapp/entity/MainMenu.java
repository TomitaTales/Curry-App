package com.example.curryapp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "main_menu")
public class MainMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "genre", length = 100)
    private String genre;

    @Column(name = "spiciness")
    private Integer spiciness;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "ent_date", nullable = false)
    private LocalDate entDate;

    @Column(name = "ent_time", nullable = false)
    private LocalTime entTime;

    @Column(name = "upd_date", nullable = false)
    private LocalDate updDate;

    @Column(name = "upd_time", nullable = false)
    private LocalTime updTime;

    public MainMenu() {}

    public MainMenu(String name, Integer price, String genre, Integer spiciness) {
        this.name = name;
        this.price = price;
        this.genre = genre;
        this.spiciness = spiciness;
        this.isActive = true;
    }

    @PrePersist
    public void prePersist() {
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();

        this.entDate = nowDate;
        this.entTime = nowTime;
        this.updDate = nowDate;
        this.updTime = nowTime;

        if (this.isActive == null) {
            this.isActive = true;
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updDate = LocalDate.now();
        this.updTime = LocalTime.now();
    }

    // --- Getter / Setter ---

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getSpiciness() {
        return spiciness;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDate getEntDate() {
        return entDate;
    }

    public LocalTime getEntTime() {
        return entTime;
    }

    public LocalDate getUpdDate() {
        return updDate;
    }

    public LocalTime getUpdTime() {
        return updTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSpiciness(Integer spiciness) {
        this.spiciness = spiciness;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}