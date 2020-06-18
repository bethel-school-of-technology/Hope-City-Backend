package com.codebrew.controllers;

import java.util.List;

//import java.util.List;

import com.codebrew.models.Attendees;
import com.codebrew.models.Events;
//import com.codebrew.models.Events;
import com.codebrew.repository.EventsRepository;
import com.codebrew.repository.UserEventsRepo;
import com.codebrew.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/attendees")
public class AttendeesController {

    @Autowired
    EventsRepository eventsRepository;
    UsersRepository usersRepository;
    UserEventsRepo userEventsRepo;

    // @GetMapping("/getallattendees")
    // public List<Attendees> getAttendees() {
    //     List<Attendees> foundAttendees = UserEventsRepo.findAll();
    //     return foundAttendees;
    // }

    @GetMapping("get/{id}")
    public ResponseEntity<Attendees> getAttendees(@PathVariable("id") Long id) {
        Attendees foundAttendee = userEventsRepo.findAll(id);

        if (foundAttendee == null) {
            return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
        }
        System.out.println("got Attendee");
        return ResponseEntity.ok(foundAttendee);
    }

    @PostMapping("/attend")

    public ResponseEntity<Attendees> postAttendees(@RequestBody Attendees attendees) {
        Attendees createdAttendees = userEventsRepo.saveAll(attendees);
        System.out.println("attend");
        return ResponseEntity.ok(createdAttendees);
    }

    // @PostMapping("/attend")

    // public ResponseEntity<Object> postAttendees(@RequestBody Attendees attendees) {
    //     System.out.println("attending");
    //     return ResponseEntity.ok(postAttendees());

    // }

    public Object postAttendees() {
        return null;
    }

}