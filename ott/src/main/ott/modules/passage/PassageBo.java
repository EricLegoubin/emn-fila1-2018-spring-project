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
@EqualsAndHashCode(of={"id", "version"})
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

    public PassageBo() {
    }

    public PassageBo(LocalDateTime localDateTime, PointBo point) {
        this.localDateTime = localDateTime;
        this.point = point;
    }
}
