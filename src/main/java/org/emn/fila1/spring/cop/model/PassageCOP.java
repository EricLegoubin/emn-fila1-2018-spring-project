package org.emn.fila1.spring.cop.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class PassageCOP implements Serializable {


    private static final long serialVersionUID = -3543324529521859997L;

    @Id
    String id;
    Pi pi;
    String idCourse;
    Date theoricalDate;
    Date calculatedDate;
    Date operatorDate;
    boolean cancelled;

    public PassageCOP() {
        super();
    }

    public PassageCOP(Passage passage) {
        this.id = passage.getId();
        this.pi = passage.getPi();
        this.idCourse = passage.getIdCourse();
        this.theoricalDate = passage.getDate();
        this.calculatedDate = this.theoricalDate;
        this.operatorDate = this.theoricalDate;
        this.cancelled=false;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pi getPi() {
        return pi;
    }

    public void setPi(Pi pi) {
        this.pi = pi;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public Date getTheoricalDate() {
        return theoricalDate;
    }

    public void setTheoricalDate(Date theoricalDate) {
        this.theoricalDate = theoricalDate;
    }

    public Date getCalculatedDate() {
        return calculatedDate;
    }

    public void setCalculatedDate(Date calculatedDate) {
        this.calculatedDate = calculatedDate;
    }

    public Date getOperatorDate() {
        return operatorDate;
    }

    public void setOperatorDate(Date operatorDate) {
        this.operatorDate = operatorDate;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}

