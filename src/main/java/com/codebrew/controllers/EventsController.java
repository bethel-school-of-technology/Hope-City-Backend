package com.codebrew.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.codebrew.dao.EventRepository;
import com.codebrew.models.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    @Autowired
    EventRepository doa;

    @GetMapping("/events")
    public List<Events> getEvents() {
        List<Events> foundEvents = doa.findAll();
        return foundEvents;
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Events> getEvents(@PathVariable("id") Integer id) {
        Events foundEvent = doa.findByEventId(id).orElse(null);

        if(foundEvent == null) {
            return ResponseEntity.notFound().header("Events", "Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundEvent);
    }

    @PostMapping("/events")

    public ResponseEntity<Events> postMessage(@RequestBody Events events) {

        Events createdEvents = doa.save(events);

        return ResponseEntity.ok(createdEvents);

    }

    

  
   public String getAllEvents(Model model) {
       List<Events> events = new ArrayList<Events> ();  
    model.addAttribute("events", events);
    return "events";
    }

}