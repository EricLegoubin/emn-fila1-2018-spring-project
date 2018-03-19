package main.ott.modules.sillon;

import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointDto;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "sillons")
@Table(name = "sillons")
public class SillonBo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<PointBo> points;

    public SillonBo() {
    	super();
    }

    public SillonBo(Long id, Set<PointBo> poiIds) {
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

    public Set<PointBo> getPoints() {
        return points;
    }

    public void setPoints(Set<PointBo> points) {
        this.points = points;
    }
}
