package com.codebrew.controllers;

import java.util.List;

import com.codebrew.models.Events;
import com.codebrew.repository.EventsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    EventsRepository eventsRepository;

    // GET ALL
    @GetMapping("/getall")
    public List<Events> getEvents() {
        List<Events> foundEvents = eventsRepository.findAll();
        return foundEvents;
    }

    // GET ONE
    @GetMapping("/get/{id}")
    public ResponseEntity<Events> getEvents(@PathVariable("id") Long id) {
        Events foundEvent = eventsRepository.findEventById(id);

        if (foundEvent == null) {
            return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundEvent);
    }

    // CREATE
    @PostMapping("/create")

    public ResponseEntity<Events> postEvents(@RequestBody Events events) {
        Events createdEvents = eventsRepository.save(events);
        return ResponseEntity.ok(createdEvents);
    }

    // DELETE ONE

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Events> deleteEventById(@PathVariable(value = "id") Long id) {
        Events foundEvent = eventsRepository.findEventById(id);

        if (foundEvent == null) {
            return ResponseEntity.notFound().header("message", "Event Not Found").build();

        } else {
            eventsRepository.delete(foundEvent);
        }
        return ResponseEntity.ok().build();
    }

    //UPDATE

     @PostMapping("/update/{id}")

    public ResponseEntity<Events> updateEventById(@PathVariable(value = "id")Long id) {
        Events foundEvent = eventsRepository.findEventById(id);

        if (foundEvent == null) {
            return ResponseEntity.notFound().header("message", "Event Not Found").build();

        } else {
            eventsRepository.update(foundEvent);
        }
        return ResponseEntity.ok().build();
    }
      

}