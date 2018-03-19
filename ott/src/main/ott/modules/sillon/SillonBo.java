package main.ott.modules.sillon;

import main.ott.modules.course.CourseBo;
import main.ott.modules.point.PointBo;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "sillons")
@Table(name = "sillons")
public class SillonBo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private Long version;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "points_sillons")
    private Set<PointBo> points;

    public SillonBo() {
        super();
    }

    public SillonBo(Set<PointBo> points) {
        super();
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Set<PointBo> getPoints() {
        return points;
    }

    public void setPoints(Set<PointBo> points) {
        this.points = points;
    }
}
