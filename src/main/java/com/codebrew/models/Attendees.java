package com.codebrew.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;


@Entity
@Table(name = "USER_EVENTS")
public class Attendees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    // private static final Object Attendees = null;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    public Users user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id")
    public Events event;

    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
}