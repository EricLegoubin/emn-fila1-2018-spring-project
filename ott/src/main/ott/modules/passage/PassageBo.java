package main.ott.modules.passage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.ott.modules.course.CourseBo;
import main.ott.modules.point.PointBo;

import javax.persistence.*;

import java.sql.Timestamp;
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
    private Timestamp timeStamp;

    @ManyToOne(cascade = CascadeType.ALL)
    private PointBo point;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CourseBo> courses;

    public PassageBo() {
    }

    public PassageBo(Timestamp timeStamp, PointBo point, Set<CourseBo> courses) {
        this.timeStamp = timeStamp;
        this.point = point;
        this.courses = courses;
    }
}
