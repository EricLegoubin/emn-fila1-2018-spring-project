package main.ott.modules.sillon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.ott.modules.course.CourseBo;
import main.ott.modules.point.PointBo;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "sillons")
@Table(name = "sillons")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "version"})
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

}
