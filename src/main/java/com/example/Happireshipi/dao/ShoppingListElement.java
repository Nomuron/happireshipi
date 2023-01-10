package com.example.Happireshipi.dao;

public class ShoppingListElement {

    private String name;
    private Float amount;
    private String measure;

    public ShoppingListElement(String name, Float amount, String measure) {
        this.name = name;
        this.amount = amount;
        this.measure = measure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
