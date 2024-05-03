package com.example.mealrater.data;
public class Data {
    private String restaurantName, dishName, rating;

    public Data(String restaurantName, String dishName, String rating) {
        this.restaurantName = restaurantName;
        this.dishName = dishName;
        this.rating = rating;
    }

    public Data() {
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
