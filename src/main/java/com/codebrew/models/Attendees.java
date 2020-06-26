package com.codebrew.models;

import javax.persistence.Column;
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
   
    // public int eventId;
    // public int userId;
   // private static final Object Attendees = null;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false )
    public Users user;
    private int user_id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Events event;
    private int event_id;

   

    // @PostMapping("/attending")

    // public ResponseEntity<Object> postAttendees(@RequestBody Attendees attendees) {
    //     System.out.println("attending");
    //     return ResponseEntity.ok(Attendees);

  //  }

    /**
     * @return Users return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * @return Events return the event
     */
    public Events getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Events event) {
        this.event = event;
    }


  public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int geteventId(int event_id) {
        return this.event_id;
    }

    public void seteventId(int event_id) {
        this.event_id = event_id;
    }

public int getuserId(int user_id){
    return this.user_id;
}
    public void setuserId(int user_id) {
        this.user_id = user_id;
    }
}