package com.emn.GEO.service.dto;

import java.util.List;

import java.util.Set;

public class SillonDTO {

    private Long id;

    private Long version;

    private Set<POIDTO> points;
    
    public SillonDTO() {
    	super();
    }

    public SillonDTO(Long id, Set<POIDTO> poiIds) {
    	super();
        this.id = id;
        this.points = poiIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<POIDTO> getPoints() {
        return points;
    }

    public void setPoints(Set<POIDTO> points) {
        this.points = points;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}