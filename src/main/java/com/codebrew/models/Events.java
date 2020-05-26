package com.codebrew.models;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
// import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false, unique = false)
    public String eventName;
    public String eventInfo;
    public String eventAddress;
    public String eventCity;
    public String eventState;
    public int eventZip;
    public Time eventTime;
    public Date eventDay;

    // @ManyToMany(mappedBy = "")
    // Set<Users> userIdAttending;


    public Events() {
        super();
    }

    public Events(Long id, String eventName, String eventInfo, String eventAddress, String eventCity,
            String eventState, int eventZip, Time eventTime, Date eventDay) {
        this.id = id;
        this.eventName = eventName;
        this.eventInfo = eventInfo;
        this.eventAddress = eventAddress;
        this.eventCity = eventCity;
        this.eventState = eventState;
        this.eventZip = eventZip;
        this.eventTime = eventTime;
        this.eventDay = eventDay;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Time getEventTime() {
        return this.eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
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

    public Events eventTime(Time eventTime) {
        this.eventTime = eventTime;
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
        return Objects.equals(id, events.id) && Objects.equals(eventName, events.eventName)
                && Objects.equals(eventInfo, events.eventInfo) && Objects.equals(eventAddress, events.eventAddress)
                && Objects.equals(eventCity, events.eventCity) && Objects.equals(eventState, events.eventState)
                && eventZip == events.eventZip && Objects.equals(eventTime, events.eventTime)
                && Objects.equals(eventDay, events.eventDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, eventInfo, eventAddress, eventCity, eventState, eventZip, eventTime,
                eventDay);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", eventName='" + getEventName() + "'" + ", eventInfo='" + getEventInfo()
                + "'" + ", eventAddress='" + getEventAddress() + "'" + ", eventCity='" + getEventCity() + "'"
                + ", eventState='" + getEventState() + "'" + ", eventZip='" + getEventZip() + "'" + ", eventTime='"
                + getEventTime() + "'" + ", eventDay='" + getEventDay() + "'" + "}";
    }

	public Events orElse(Object object) {
		return null;
	}
}