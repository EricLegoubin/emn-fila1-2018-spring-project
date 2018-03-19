package com.emn.GEO.service.dto;

import java.security.Timestamp;


public class PassageDTO {

    private Timestamp localDateTime;

    private POIDTO point;
    
    public PassageDTO() {
    	super();
    }

    public PassageDTO(Timestamp localDateTime, POIDTO point) {
    	super();
        this.localDateTime = localDateTime;
        this.point = point;
    }

    public POIDTO getPoint() {
        return point;
    }

    public void setPoint(POIDTO point) {
        this.point = point;
    }

    public Timestamp getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(Timestamp localDateTime) {
        this.localDateTime = localDateTime;
    }
}