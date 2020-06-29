package com.codebrew.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false, unique = false)
    public String hostName;
    public String eventName;
    public String eventInfo;
    public String eventAddress;
    public String eventCity;
    public String eventState;
    public int eventZip;
    public String eventStartTime;
    public String eventEndTime;
    public Date eventDay;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
@JoinTable(name = "user_events",
    joinColumns = { @JoinColumn(name = "event_id", referencedColumnName = "id"), },
    inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
public Set<Users> users = new HashSet<>();



    public Events() {
    }

    public Events(Long id, String hostName, String eventName, String eventInfo, String eventAddress, String eventCity, String eventState, int eventZip, String eventStartTime, String eventEndTime, Date eventDay) {
        this.id = id;
        this.hostName = hostName;
        this.eventName = eventName;
        this.eventInfo = eventInfo;
        this.eventAddress = eventAddress;
        this.eventCity = eventCity;
        this.eventState = eventState;
        this.eventZip = eventZip;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventDay = eventDay;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostName() {
        return this.hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventInfo() {
        return this.eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public String getEventAddress() {
        return this.eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventCity() {
        return this.eventCity;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    public String getEventState() {
        return this.eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState;
    }

    public int getEventZip() {
        return this.eventZip;
    }

    public void setEventZip(int eventZip) {
        this.eventZip = eventZip;
    }

    public String getEventStartTime() {
        return this.eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return this.eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Date getEventDay() {
        return this.eventDay;
    }

    public void setEventDay(Date eventDay) {
        this.eventDay = eventDay;
    }

    public Events id(Long id) {
        this.id = id;
        return this;
    }

    public Events hostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public Events eventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public Events eventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
        return this;
    }

    public Events eventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
        return this;
    }

    public Events eventCity(String eventCity) {
        this.eventCity = eventCity;
        return this;
    }

    public Events eventState(String eventState) {
        this.eventState = eventState;
        return this;
    }

    public Events eventZip(int eventZip) {
        this.eventZip = eventZip;
        return this;
    }

    public Events eventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
        return this;
    }
    public Events eventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
        return this;
    }

    public Events eventDay(Date eventDay) {
        this.eventDay = eventDay;
        return this;
    }

  
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Events)) {
            return false;
        }
        Events events = (Events) o;
        return Objects.equals(id, events.id) && Objects.equals(hostName, events.hostName)
                && Objects.equals(eventName, events.eventName) && Objects.equals(eventInfo, events.eventInfo)
                && Objects.equals(eventAddress, events.eventAddress) && Objects.equals(eventCity, events.eventCity)
                && Objects.equals(eventState, events.eventState) && eventZip == events.eventZip
                && Objects.equals(eventStartTime, events.eventStartTime) && Objects.equals(eventDay, events.eventDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hostName, eventName, eventInfo, eventAddress, eventCity, eventState, eventZip,
                eventStartTime, eventDay);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", hostName='" + getHostName() + "'" +
            ", eventName='" + getEventName() + "'" +
            ", eventInfo='" + getEventInfo() + "'" +
            ", eventAddress='" + getEventAddress() + "'" +
            ", eventCity='" + getEventCity() + "'" +
            ", eventState='" + getEventState() + "'" +
            ", eventZip='" + getEventZip() + "'" +
            ", eventStartTime='" + getEventStartTime() + "'" +
            ", eventEndTime='" + getEventEndTime() + "'" +
            ", eventDay='" + getEventDay() + "'" +
            "}";
    }

	public Object getUsers() {
		return null;
	}
    
    
}