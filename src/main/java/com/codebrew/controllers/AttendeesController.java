package com.codebrew.controllers;

import java.util.List;

//import java.util.List;

//import java.util.List;

import com.codebrew.models.Attendees;
import com.codebrew.repository.EventsRepository;
//import com.codebrew.models.Events;
//import com.codebrew.repository.EventsRepository;
import com.codebrew.repository.UserEventsRepo;
//import com.codebrew.repository.UsersRepository;
import com.codebrew.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/attendees")
public class AttendeesController {

    @Autowired
    
    UserEventsRepo userEventsRepo;

   


    @GetMapping("/getall")
    private List<Attendees> getAttendees() {
        List<Attendees> foundAttendees = userEventsRepo.findAll();
        return foundAttendees;
    } 

    @PostMapping("/attending")

    public ResponseEntity<Attendees> postAttendees(@RequestBody Attendees attendees) {
        Attendees createdAttendees = userEventsRepo.save(attendees);
        System.out.println("attending");
        return ResponseEntity.ok(createdAttendees);

    }


    // @GetMapping("/get/attendees")
    // public ResponseEntity<Attendees> getAttendees(@PathVariable("id") Long id) {
    //     Attendees foundAttendee = UserEventsRepo.findAll(id);

    //     if (foundAttendee == null) {
    //         return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
    //     }
    //     System.out.println("got event id");
    //     return ResponseEntity.ok(foundAttendee);
    // }

     // @GetMapping("/getall")
    // public List<Attendees> getEvents() {
    //     List<Attendees> foundAttendees = userEventsRepo.findAll();
    //     return foundAttendees;
    // }
     // @GetMapping("/getall")
    // public List<Attendees> getEvents() {
    //     List<Attendees> foundAttendees = userEventsRepo.findAll();
    //     return foundAttendees;
    // }


    // @PostMapping("/create")

    // public ResponseEntity<Attendees> postEvents(@RequestBody Attendees attendees) {
    //     Attendees createdEvents = userEventsRepo.save(attendees);
    //     System.out.println("event created");
    //     return ResponseEntity.ok(createdEvents);
    // }

    // @PostMapping("/attending")

    // public ResponseEntity<Object> postAttendees(@RequestBody Attendees attendees) {
    //     System.out.println("attending");
    //     return ResponseEntity.ok(postAttendees());

    // }

    // public Object postAttendees() {
    //     return null;
    // }

}