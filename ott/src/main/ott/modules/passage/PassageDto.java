package main.ott.modules.passage;

import main.ott.modules.point.PointDto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PassageDto {

    private Timestamp localDateTime;

    private PointDto point;
    
    public PassageDto() {
    	super();
    }

    public PassageDto(Timestamp localDateTime, PointDto point) {
    	super();
        this.localDateTime = localDateTime;
        this.point = point;
    }

    public PointDto getPoint() {
        return point;
    }

    public void setPoint(PointDto point) {
        this.point = point;
    }

    public Timestamp getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(Timestamp localDateTime) {
        this.localDateTime = localDateTime;
    }
}
