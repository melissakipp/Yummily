package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcRestaurantDao implements RestaurantDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Restaurant> findRestaurants(String zipCode) {

        List<Restaurant> restaurants = new ArrayList<>();
        String sqlStatement = "SELECT " +
                "restaurant_id, " +
                "restaurant_name, " +
                "phone_number, " +
                "email, " +
                "address, " +
                "city, " +
                "state, " +
                "zip_code, " +
                "rating, " +
                "slogan, " +
                "description, " +
                "image " +
                "FROM restaurants " +
                "WHERE zip_code = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement, zipCode);
        while (results.next()) {
            Restaurant restaurant = mapRowToRestaurant(results);
            restaurants.add(restaurant);
        }

        return restaurants;
    }

    private Restaurant mapRowToRestaurant(SqlRowSet rs) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(rs.getLong("restaurant_id"));
        restaurant.setRestaurantName(rs.getString("restaurant_name"));
        restaurant.setPhoneNumber(rs.getString("phone_number"));
        restaurant.setEmail(rs.getString("email"));
        restaurant.setAddress(rs.getString("address"));
        restaurant.setCity(rs.getString("city"));
        restaurant.setState(rs.getString("state"));
        restaurant.setZipCode(rs.getString("zip_code"));
        restaurant.setRating(rs.getInt("rating"));
        restaurant.setSlogan(rs.getString("slogan"));
        restaurant.setDescription(rs.getString("description"));
        restaurant.setImage(rs.getString("image"));
        return restaurant;
    }

}
