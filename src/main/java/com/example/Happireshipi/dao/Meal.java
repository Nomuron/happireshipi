package com.example.Happireshipi.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Meal {

    @Id
    private Integer id;
    private String name;
    private Integer perPortionCalories;
    private String category;
    private String recipe;
    private Double proteins;
    private Double carbohydrates;
    private Double fats;

    public Meal() {
    }

    public Meal(Integer id, String name, Integer perPortionCalories, String category, String recipe, Double proteins, Double carbohydrates, Double fats) {
        this.id = id;
        this.name = name;
        this.perPortionCalories = perPortionCalories;
        this.category = category;
        this.recipe = recipe;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPerPortionCalories() {
        return perPortionCalories;
    }

    public void setPerPortionCalories(Integer perPortionCalories) {
        this.perPortionCalories = perPortionCalories;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }
}
