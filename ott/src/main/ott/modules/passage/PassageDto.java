package main.ott.modules.passage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.ott.modules.point.PointDto;

import java.sql.Timestamp;

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
    private Timestamp localDateTime;
    /**
     * Le point où le train passe
     */
    private PointDto point;
    public PassageDto() {
    	super();
    }

    public PassageDto(Timestamp localDateTime, PointDto point) {
    	super();
        this.localDateTime = localDateTime;
        this.point = point;
    }
}
