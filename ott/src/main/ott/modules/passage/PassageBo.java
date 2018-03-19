package main.ott.modules.passage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.ott.modules.course.CourseBo;
import main.ott.modules.point.PointBo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "passages")
@Table(name = "passages")
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class PassageBo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "dateTime")
    private LocalDateTime localDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private PointBo point;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CourseBo> courses;

    public PassageBo() {
    }

    public PassageBo(LocalDateTime localDateTime, PointBo point, Set<CourseBo> courses) {
        this.localDateTime = localDateTime;
        this.point = point;
        this.courses = courses;
    }
}
