package main.ott.modules.sillon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointDto;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "sillons")
@Table(name = "sillons")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class SillonBo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
}
