package main.ott.modules.passage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.ott.modules.course.CourseDto;
import main.ott.modules.point.PointDto;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
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
    private List<CourseDto> courses;

    public PassageDto() {
    	super();
    }

    public PassageDto(Timestamp timestamp, PointDto point) {
    	super();
        this.timestamp = timestamp;
        this.point = point;
    }

}
