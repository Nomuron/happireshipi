package com.example.Happireshipi.dao;

public class ShoppingListElement {

    private String name;
    private Integer amount;
    private String measure;
    private String nameOfMeasure;

    public ShoppingListElement(String name, Integer amount, String measure, String nameOfMeasure) {
        this.name = name;
        this.amount = amount;
        this.measure = measure;
        this.nameOfMeasure = nameOfMeasure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getNameOfMeasure() {
        return nameOfMeasure;
    }

    public void setNameOfMeasure(String nameOfMeasure) {
        this.nameOfMeasure = nameOfMeasure;
    }
}
