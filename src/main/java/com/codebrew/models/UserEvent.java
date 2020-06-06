package com.codebrew.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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

    public void setEvents(Object object) {
        this.events = (Events) object;
    }


	public Users getUser(Users user) {
		return null;
	}


	public Object getEvent(Events event) {
		return null;
	}


	public static Object notFound() {
		return null;
	}


	public Object header(String string, String string2) {
		return null;
	}


	public UserEvent build() {
		return null;
	}

}
