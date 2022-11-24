package com.example.Happireshipi.model;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(name = "measure", length = 40)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String measure;

    @Column(name = "name", length = 70)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @OneToMany(mappedBy = "ingredient")
    private Set<MealIngredient> mealIngredients = new LinkedHashSet<>();

    public Set<MealIngredient> getMealIngredients() {
        return mealIngredients;
    }

    public void setMealIngredients(Set<MealIngredient> mealIngredients) {
        this.mealIngredients = mealIngredients;
    }

    public Ingredient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
