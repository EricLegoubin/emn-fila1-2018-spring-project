package main.ott.modules.sillon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.ott.modules.point.PointDto;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of ={"id"})
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
}
