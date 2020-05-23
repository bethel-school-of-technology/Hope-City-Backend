package com.codebrew.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.codebrew.dao.EventRepository;
import com.codebrew.models.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    @Autowired
    EventRepository doa;

    @GetMapping("/events")
    public List<Events> getEvents() {
        List<Events> foundEvents = dao.findAll();
        return foundEvents;
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Events> getEvents(@PathVariable("id") Integer id) {
        Events foundEvent = dao.findById(id).orElse(null);

        if(foundEvent == null) {
            return ResponseEntity.notFound().header("message", "Nothing found with that id").build();
        }
        else {
            dao.delete(foundEvent);
        }
        return ResponseEntity.ok().build();
        }
    }

  
   public String getAllEvents(Model model) {
       List<Events> events = new ArrayList<Events> ();  
    model.addAttribute("events", events);
    return "events";
    }

}