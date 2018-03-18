package main.ott.modules.passage;

import main.ott.modules.point.PointDto;

import java.time.LocalDateTime;

public class PassageDto {

    private LocalDateTime localDateTime;

    private PointDto point;
    
    public PassageDto() {
    	super();
    }

    public PassageDto(LocalDateTime localDateTime, PointDto point) {
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
