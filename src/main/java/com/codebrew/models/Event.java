package com.codebrew.models;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public String eventName;
    public String eventAddress;
    public String eventCity;
    public String eventState;
    public int eventZip;
    public Date eventDay;
    public String eventInfo;

    
    public Event() {
        super();
    }

    public Event(long id, String eventName, String eventAddress, String eventCity, String eventState, int eventZip,
            Date eventDay, String eventInfo) {
        this.id = id;
        this.eventName = eventName;
        this.eventAddress = eventAddress;
        this.eventCity = eventCity;
        this.eventState = eventState;
        this.eventZip = eventZip;
        this.eventDay = eventDay;
        this.eventInfo = eventInfo;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public Date getEventDay() {
        return this.eventDay;
    }

    public void setEventDay(Date eventDay) {
        this.eventDay = eventDay;
    }

    public String getEventInfo() {
        return this.eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public Event id(long id) {
        this.id = id;
        return this;
    }

    public Event eventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public Event eventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
        return this;
    }

    public Event eventCity(String eventCity) {
        this.eventCity = eventCity;
        return this;
    }

    public Event eventState(String eventState) {
        this.eventState = eventState;
        return this;
    }

    public Event eventZip(int eventZip) {
        this.eventZip = eventZip;
        return this;
    }

    public Event eventDay(Date eventDay) {
        this.eventDay = eventDay;
        return this;
    }

    public Event eventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return id == event.id && Objects.equals(eventName, event.eventName)
                && Objects.equals(eventAddress, event.eventAddress) && Objects.equals(eventCity, event.eventCity)
                && Objects.equals(eventState, event.eventState) && eventZip == event.eventZip
                && Objects.equals(eventDay, event.eventDay) && Objects.equals(eventInfo, event.eventInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, eventAddress, eventCity, eventState, eventZip, eventDay, eventInfo);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", eventName='" + getEventName() + "'" + ", eventAddress='"
                + getEventAddress() + "'" + ", eventCity='" + getEventCity() + "'" + ", eventState='" + getEventState()
                + "'" + ", eventZip='" + getEventZip() + "'" + ", eventDay='" + getEventDay() + "'" + ", eventInfo='"
                + getEventInfo() + "'" + "}";
    }

}