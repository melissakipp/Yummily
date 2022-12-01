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
                "image, " +
                "open,  " +
                "close, " +
                "category, " +
                "type_of_food " +
                "FROM restaurants " +
                "WHERE zip_code = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement, zipCode);
        while (results.next()) {
            Restaurant restaurant = mapRowToRestaurant(results);
            restaurants.add(restaurant);
        }

        return restaurants;
    }
    @Override
    public List<Restaurant> filterByType(String type){

        List<Restaurant> restaurantByType = new ArrayList<>();


        String sql = "select r.*,t.type" +
                " from restaurants as r " +
                "inner join type_of_food as t " +
                "on t.type_id = r.type_of_food " +
                "where t.type = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);
        while (results.next()){
            Restaurant restaurant = mapRowToRestaurant(results);
            restaurantByType.add(restaurant);

        }

        return restaurantByType;

    }
    @Override
    public List<Restaurant> filterByZipType(String zipCode, Integer type){

        List<Restaurant> restaurantByZipType = new ArrayList<>();


        String sql = "select r.*,t.type" +
                " from restaurants as r " +
                "inner join type_of_food as t " +
                "on t.type_id = r.type_of_food " +
                "where r.zip_code = ?" +
                "and  r.type_of_food = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);
        while (results.next()){
            Restaurant restaurant = mapRowToRestaurant(results);
            restaurantByZipType.add(restaurant);

        }

        return restaurantByZipType;

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
        restaurant.setOpen(rs.getString("open"));
        restaurant.setClose(rs.getString("close"));
        restaurant.setCategory(rs.getString("category"));
        restaurant.setTypeOfFood(rs.getString("type_of_food"));
        return restaurant;
    }

}
