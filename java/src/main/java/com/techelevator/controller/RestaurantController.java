package com.techelevator.controller;

import com.techelevator.dao.JdbcRestaurantDao;
import com.techelevator.model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RestaurantController {

    private final JdbcRestaurantDao restaurantDao;

    public RestaurantController(JdbcRestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/restaurants/{zipCode}", method = RequestMethod.GET)
    public List<Restaurant> getRestaurantsByZipCode(@PathVariable String zipCode) {
        return restaurantDao.findRestaurants(zipCode);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurants/type={type}", method = RequestMethod.GET)
    public List<Restaurant> filterByType(@PathVariable  String type) {
        return restaurantDao.filterByType(type);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurants/{zipCode}/{type}", method = RequestMethod.GET)
    public List<Restaurant> filterByZipType(@PathVariable  String zipCode, Integer type) {
        return restaurantDao.filterByZipType(zipCode, type);
    }

}
