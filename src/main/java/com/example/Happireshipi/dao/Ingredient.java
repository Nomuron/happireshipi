package com.example.Happireshipi.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(nullable = false, length = 40)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String measure;

    @Column(nullable = false, length = 70)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @OneToMany(mappedBy = "ingredient", orphanRemoval = true)
    @JsonBackReference
    private List<MealIngredient> mealIngredients = new ArrayList<>();

    public List<MealIngredient> getMealIngredients() {
        return mealIngredients;
    }

    public void setMealIngredients(List<MealIngredient> mealIngredients) {
        this.mealIngredients = mealIngredients;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getMeasure() {
        return measure;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
