package com.codebrew.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepository;

    // GET ALL EVENTS
    @GetMapping("/allEvents")
    public List<Event> getEvents() {
        List<Event> foundEvents = eventRepository.findAll();
        return foundEvents;
    }

    // GET ONE EVENT
    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getMessage(@PathVariable("id") Long id) {
        Event foundEvent = eventRepository.findById(id).orElse(null);

        if (foundEvent == null) {
            return ResponseEntity.notFound().header("Event", "No Events found with that id").build();
        }
        return ResponseEntity.ok(foundEvent);
    }

    // POST EVENT
    @PostMapping("/event")
    public ResponseEntity<Event> postEvent(@RequestBody Event event) {
        Event createdEvent = eventRepository.save(event);

        return ResponseEntity.ok(createdEvent);
    }

    @PutMapping("/event")
    public ResponseEntity<Event> newEvent(@PathVariable(value = "id") Long id, @RequestBody Event event)
            throws Exception {
        Event uEvent = eventRepository.findById(id).orElse(null);

        if (uEvent == null) {
            return ResponseEntity.notFound().header("Message", "Event not found").build();
        } else {
            uEvent.setEventName(event.getEventName());
            uEvent.setEventAddress(event.getEventAddress());
            uEvent.setEventCity(event.getEventCity());
            uEvent.setEventState(event.getEventState());
            uEvent.setEventZip(event.getEventZip());
            uEvent.setEventDay(event.getEventDay());
            uEvent.setEventInfo(event.getEventInfo());
            eventRepository.save(uEvent);
        }
        return ResponseEntity.ok(uEvent);

    }

    // UPDATE EVENT
    @PutMapping("/event/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long id) {
        Event foundEvent = eventRepository.findById(id).orElse(null);

        if (foundEvent == null) {
            return ResponseEntity.notFound().header("Event", "No Events found with that id").build();
        } else {
            eventRepository.save(foundEvent);
        }
        return ResponseEntity.ok().build();
    }

    // DELETE ONE EVENT
    @DeleteMapping("/event/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable(value = "id") Long id) {
        Event foundEvent = eventRepository.findById(id).orElse(null);

        if (foundEvent == null) {
            return ResponseEntity.notFound().header("Event", "No Events found with that id").build();
        } else {
            eventRepository.delete(foundEvent);
        }
        return ResponseEntity.ok().build();
    }
}