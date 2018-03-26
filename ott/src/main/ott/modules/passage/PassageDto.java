package main.ott.modules.passage;

import main.ott.modules.course.CourseDto;
import main.ott.modules.point.PointDto;

import java.sql.Timestamp;
import java.util.List;

/**
 * Classe qui représente un passage d'un train à un lieu et une heure
 */
public class PassageDto {

    /**
     * L'heure de passage
     */
    private Timestamp timestamp;
    /**
     * Le point où le train passe
     */
    private PointDto point;

    /**
     * Les courses liées à ce passage
     */
    private CourseDto course;

    public PassageDto() {
    	super();
    }

    public PassageDto(Timestamp timestamp, PointDto point) {
    	super();
        this.timestamp = timestamp;
        this.point = point;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public PointDto getPoint() {
        return point;
    }

    public void setPoint(PointDto point) {
        this.point = point;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }
}
