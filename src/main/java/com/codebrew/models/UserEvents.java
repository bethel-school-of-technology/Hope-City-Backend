package com.codebrew.models;

//import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

//import io.jsonwebtoken.lang.Objects;

@Entity(name = "UserEvents")
@Table(name = "USER_EVENTS")
public class UserEvents {
    @EmbeddedId
    public UserEvents id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("eventsId")
    private Events events;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private Users users;
 
 
    public UserEvents(Long long1, Integer integer) {}
 
    public UserEvents(Events events, Users users) {
        this.events = events;
        this.users = users;
        this.id = new UserEvents(events.getId(), users.getId());
    }
 
    //Getters and setters omitted for brevity
 
    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
 
    //     if (o == null || getClass() != o.getClass())
    //         return false;
 
    //     UserEvents that = (UserEvents) o;
    //     return Objects.equals(events, that.events) &&
    //            Objects.equals(users, that.users);
    // }
 
    // @Override
    // public int hashCode() {
    //     return Objects.hash(events, users);
    // }

}