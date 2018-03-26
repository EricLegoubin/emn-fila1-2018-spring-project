package main.ott.modules.passage;

import main.ott.modules.point.PointBo;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "passages")
@Table(name = "passages")
public class PassageBo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "dateTime")
    private Timestamp timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    private PointBo point;

    public PassageBo() {
    }

    public PassageBo(Timestamp timestamp, PointBo point) {
        this.timestamp = timestamp;
        this.point = point;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp localDateTime) {
        this.timestamp = localDateTime;
    }

    public PointBo getPoint() {
        return point;
    }

    public void setPoint(PointBo point) {
        this.point = point;
    }
}
