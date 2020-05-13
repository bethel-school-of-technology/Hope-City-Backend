package com.codebrew.models;
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

    public Event() {
    }

    public Event(long id, String eventName, String eventAddress, String eventCity, String eventState,
            int eventZip) {
        this.id = id;
        this.eventName = eventName;
        this.eventAddress = eventAddress;
        this.eventCity = eventCity;
        this.eventState = eventState;
        this.eventZip = eventZip;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Event)) {
            return false;
        }
        Event eventModel = (Event) o;
        return id == eventModel.id && Objects.equals(eventName, eventModel.eventName)
                && Objects.equals(eventAddress, eventModel.eventAddress)
                && Objects.equals(eventCity, eventModel.eventCity) && Objects.equals(eventState, eventModel.eventState)
                && eventZip == eventModel.eventZip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, eventAddress, eventCity, eventState, eventZip);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", eventName='" + getEventName() + "'" + ", eventAddress='"
                + getEventAddress() + "'" + ", eventCity='" + getEventCity() + "'" + ", eventState='" + getEventState()
                + "'" + ", eventZip='" + getEventZip() + "'" + "}";
    }

}