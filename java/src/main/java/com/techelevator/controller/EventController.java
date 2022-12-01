package com.techelevator.controller;


import com.techelevator.dao.EventDao;

import com.techelevator.model.Event;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
public class EventController {


    private EventDao eventDao;

    public EventController(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "event/{eventID}", method = RequestMethod.GET)
    public Event getEventByID(@PathVariable int eventID) {
        return eventDao.findEventById(eventID);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "events/{userID}", method = RequestMethod.GET)
    public List<Event> getEventByUserID(@PathVariable int userID) {
        return eventDao.findEventsByUserId(userID);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "event", method = RequestMethod.POST)
    public Event createEvent(@Valid @RequestBody Event event) {
         eventDao.create(event);
         return event;
    }
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(path = "event/{eventId}", method = RequestMethod.PUT)
    public Event updateEvent(@Valid @RequestBody Event updatedEvent, @PathVariable int eventId) {

           eventDao.update(updatedEvent);

        return updatedEvent;
                }



}
