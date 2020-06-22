package com.codebrew.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Entity
@Table(name = "USER_EVENTS")
public class Attendees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private static final Object Attendees = null;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Events event;

   

    @PostMapping("/attending")

    public ResponseEntity<Object> postAttendees(@RequestBody Attendees attendees) {
        System.out.println("attending");
        return ResponseEntity.ok(Attendees);

    }
}