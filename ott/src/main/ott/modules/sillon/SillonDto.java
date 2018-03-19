package main.ott.modules.sillon;

import main.ott.modules.point.PointDto;

import java.util.Set;

public class SillonDto {

    /**
     * Id du sillion
     */
    private Long id;
    /**
     * Points d'interets composants le sillion.
     */
    private Set<PointDto> points;

    public SillonDto() {
    	super();
    }

    public SillonDto(Long id, Set<PointDto> poiIds) {
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

    public Set<PointDto> getPoints() {
        return points;
    }

    public void setPoints(Set<PointDto> points) {
        this.points = points;
    }
}
