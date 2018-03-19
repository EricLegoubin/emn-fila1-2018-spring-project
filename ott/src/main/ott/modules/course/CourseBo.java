package main.ott.modules.course;

import main.ott.modules.passage.PassageBo;
import main.ott.modules.sillon.SillonBo;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "courses")
@Table(name = "courses")
public class CourseBo {

    @Version
    private Long version;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "train_id")
    private String idTrain;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<SillonBo> sillons;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<PassageBo> computedPassages;

    public CourseBo() {
    }

    public CourseBo(Long id, String idTrain, Set<SillonBo> sillons, Set<PassageBo> computedPassages) {
        this.id = id;
        this.idTrain = idTrain;
        this.sillons = sillons;
        this.computedPassages = computedPassages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(String idTrain) {
        this.idTrain = idTrain;
    }

    public Set<SillonBo> getSillons() {
        return sillons;
    }

    public void setSillons(Set<SillonBo> sillons) {
        this.sillons = sillons;
    }

    public Set<PassageBo> getComputedPassages() {
        return computedPassages;
    }

    public void setComputedPassages(Set<PassageBo> computedPassages) {
        this.computedPassages = computedPassages;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
