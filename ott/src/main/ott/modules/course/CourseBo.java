package main.ott.modules.course;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import main.ott.modules.passage.PassageBo;
import main.ott.modules.sillon.SillonBo;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "courses")
@Table(name = "courses")
@Getter
@Setter
@EqualsAndHashCode(of ={"id"})
public class CourseBo {

    @Version
    @Column(name = "version")
    private Long version;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

}
