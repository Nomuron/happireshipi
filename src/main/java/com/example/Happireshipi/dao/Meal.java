package com.example.Happireshipi.dao;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.*;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;
    @Column(name = "name", nullable = false, length = 100)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer perPortionCalories;
    @Column(nullable = false, length = 10)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String category;
    @Column(nullable = false, length = 400)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String imageDirectory;

    @Column(nullable = false, length = 2147483647, columnDefinition = "TEXT")
    private String recipe;
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.FLOAT)
    private Float proteins;
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.FLOAT)
    private Float carbohydrates;
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.FLOAT)
    private Float fats;

    //TODO: JOIN TABLE(JOIN COLUMNS)
    // field to Ingredients


    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Meal() {
    }

    public Meal(Integer id, String name, Integer perPortionCalories, String category, String imageDirectory, String recipe, Float proteins, Float carbohydrates, Float fats) {
        this.id = id;
        this.name = name;
        this.perPortionCalories = perPortionCalories;
        this.category = category;
        this.imageDirectory = imageDirectory;
        this.recipe = recipe;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
    }

    public Integer getId() {
        return id;
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

    public Float getProteins() {
        return proteins;
    }

    public void setProteins(Float proteins) {
        this.proteins = proteins;
    }

    public Float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Float getFats() {
        return fats;
    }

    public void setFats(Float fats) {
        this.fats = fats;
    }

}
