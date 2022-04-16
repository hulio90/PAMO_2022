package com.example.tipper;

public class Recipe {
    String name;
    Double kcalVal;
    String ingredients;
    String description;

    public Recipe(String name, Double kcalVal, String ingredients, String description) {
        this.name = name;
        this.kcalVal = kcalVal;
        this.ingredients = ingredients;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getKcalVal() {
        return kcalVal;
    }

    public void setKcalVal(Double kcalVal) {
        this.kcalVal = kcalVal;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
