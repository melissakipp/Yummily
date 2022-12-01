package com.techelevator.dao;

import com.techelevator.model.Event;

import java.util.List;


public interface EventDao {
    Event findEventById(int eventId);

    List<Event> findEventsByUserId(int userId);
    void create(Event event);
    void update(Event event);
}

