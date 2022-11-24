package com.example.Happireshipi.model;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(name = "name", length = 100)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "per_portion_calories")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer perPortionCalories;

    @Column(name = "category", length = 10)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String category;

    @Column(name = "image_directory", length = 400)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String imageDirectory;

    @Column(name = "recipe", columnDefinition = "TEXT")
    private String recipe;

    @Column(name = "proteins")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double proteins;

    @Column(name = "carbohydrates")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double carbohydrates;

    @Column(name = "fats")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double fats;

    @OneToMany(mappedBy = "meal")
    private Set<MealIngredient> mealIngredients = new LinkedHashSet<>();

    public Set<MealIngredient> getMealIngredients() {
        return mealIngredients;
    }

    public void setMealIngredients(Set<MealIngredient> mealIngredients) {
        this.mealIngredients = mealIngredients;
    }

    public Meal() {
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

    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
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
