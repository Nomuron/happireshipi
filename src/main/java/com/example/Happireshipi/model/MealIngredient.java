package com.example.Happireshipi.model;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.*;

@Entity
@Table(name = "meal_ingredient")
public class MealIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(name = "amount")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private com.example.Happireshipi.model.Meal meal;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private com.example.Happireshipi.model.Ingredient ingredient;

    public com.example.Happireshipi.model.Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(com.example.Happireshipi.model.Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public com.example.Happireshipi.model.Meal getMeal() {
        return meal;
    }

    public void setMeal(com.example.Happireshipi.model.Meal meal) {
        this.meal = meal;
    }

    public MealIngredient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}