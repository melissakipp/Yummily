package com.techelevator.dao;

import com.techelevator.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEventDao implements EventDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcEventDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Event findEventById(int eventId){
        String sql = "select event_id, " +
                "event_name, " +
                "user_id, " +
                "description, " +
                "date, " +
                "restaurant_id " +
                "from events " +
                "where event_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, eventId);
        return rowSet.next() ? mapRowToEvent(rowSet) : null;
    }

    @Override
    public List<Event> findEventsByUserId(int userId){
        List<Event> events = new ArrayList<>();
        String sql ="select event_id, " +
                "event_name, " +
                "user_id, " +
                "description, " +
                "date, " +
                "restaurant_id " +
                "from events " +
                "where user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(rowSet.next()){
            Event results = mapRowToEvent(rowSet);
            events.add(results);
        }
    return events;
    }

    @Override
    public void create(Event event) {

        String sql = "insert into events ( event_name, user_id, description, date, restaurant_id)" +
                " VALUES(?,?,?,?,?) " +
                "RETURNING event_id;";
        event.setEventId(jdbcTemplate.queryForObject(sql, Integer.class,
                event.getEventName(), event.getUserId(), event.getDescription(),
                event.getDate(), event.getRestaurantId()));
    }
    @Override
    public void update(Event event){
        String sql = "update events " +
                "set event_name=?, user_id=?, description=?, date=?, restaurant_id=?" +
                "where event_id = ?;";
        jdbcTemplate.update(sql, event.getEventName(), event.getUserId(),
                event.getDescription(), event.getDate(), event.getRestaurantId(), event.getEventId());
    }

    private Event mapRowToEvent(SqlRowSet rowSet) {
        Event event = new Event();
        event.setEventId(rowSet.getInt("event_id"));
        event.setEventName(rowSet.getString("event_name"));
        event.setUserId(rowSet.getInt("user_id"));
        event.setDescription(rowSet.getString("description"));
        event.setDate(rowSet.getString("date"));
        event.setRestaurantId(rowSet.getInt("restaurant_id"));
        return event;
    }

}
