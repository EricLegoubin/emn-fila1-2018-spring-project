package main.ott.modules.sillon;

import main.ott.modules.point.PointBo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sillons")
public class SillonBo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<PointBo> points;

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
