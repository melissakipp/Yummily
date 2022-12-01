package com.techelevator.model;
import com.techelevator.model.Event;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Event {



    private int eventId;
    private String eventName;
    private int userId;
    private String description;
    private String date;
    private int restaurantId;

    public Event(int eventId, String eventName, int userId, String description, String date, int restaurantId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.userId = userId;
        this.description = description;
        this.date = date;
        this.restaurantId = restaurantId;
    }

    public Event() {
    }


    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }


}
