package com.example.Happireshipi.dao;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.*;

@Entity
@Table(name = "meal_ingredient")
public class MealIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.FLOAT)
    private Float amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "meal_id", referencedColumnName = "id", nullable = false)
    private Meal meal;

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public MealIngredient() {
    }

    public MealIngredient(Integer id, Float amount) {
        this.id = id;
        this.amount = amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getAmount() {
        return amount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
