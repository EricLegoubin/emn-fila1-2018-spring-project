package main.ott.modules.passage;

import main.ott.modules.point.PointBo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "passage")
public class PassageBo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "dateTime")
    private LocalDateTime localDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private PointBo point;

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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public PointBo getPoint() {
        return point;
    }

    public void setPoint(PointBo point) {
        this.point = point;
    }
}
