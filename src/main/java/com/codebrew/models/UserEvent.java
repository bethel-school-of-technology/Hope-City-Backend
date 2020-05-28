package com.codebrew.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USERS_EVENTS")
public class UserEvent {
    private long id;

// ======================================
    private Users users; 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public Users getUsers() {
        return users;
    }
//======================================= 
    private Events events;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EVENT_ID")
    public Events getEvents() {
        return events;
    }

    // additional fields
    private boolean activated;
    private Date registeredDate;

    @Id
    @GeneratedValue
    @Column(name = "USER_EVENT_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Column(name = "REGISTERED_DATE")
    @Temporal(TemporalType.DATE)
    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
