package com.mycompany.myapp;

/**
 * Generic abstraction of a dish
 */
public class Dish {
    private String imageName;
    private String dishName;
    private String price;
    private String highlights;
    private String fullDescription;
    
    public Dish(String imageName, String dishName, String price, String highlights, String fullDescription) {
        this.imageName = imageName;
        this.dishName = dishName;
        this.price = price;
        this.highlights = highlights;
        this.fullDescription = fullDescription;
    }

    public String getImageName() {
        return imageName;
    }

    public String getDishName() {
        return dishName;
    }

    public String getPrice() {
        return price;
    }

    public String getHighlights() {
        return highlights;
    }

    public String getFullDescription() {
        return fullDescription;
    }
}
