package com.techelevator.dao;

import com.techelevator.model.Restaurant;

import java.util.List;

public interface RestaurantDao {

    List<Restaurant> findRestaurants(String zipCode);
    List<Restaurant> filterByType(String type);
    List<Restaurant> filterByZipType(String zipCode, Integer type);
}
