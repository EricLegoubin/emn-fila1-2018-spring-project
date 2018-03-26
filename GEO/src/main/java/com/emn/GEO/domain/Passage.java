package com.emn.GEO.domain;

import java.sql.Timestamp;

import com.emn.GEO.kafka.Sender;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Passage implements Runnable {

    private Course course;

    private POI poi;

    private Timestamp timestamp;

    public Passage() {
    }
    @JsonProperty("point")
    public void setPoi(POI poi) {
        this.poi = poi;
    }

    
    
    public Passage(Course course, POI poi, Timestamp timestamp) {
        super();
        this.course = course;
        this.poi = poi;
        this.timestamp = timestamp;
    }

    public void run() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Sender.sender.send("cop", mapper.writeValueAsString(this));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    public POI getPoi() {
        return poi;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Passage{" + "course=" + course + ", poi=" + poi + ", timestamp=" + timestamp + '}';
    }

 
    
    

}
