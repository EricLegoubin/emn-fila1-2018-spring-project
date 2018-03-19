package main.ott.modules.point;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "points")
@Table(name = "points")
@Getter
@Setter
@EqualsAndHashCode(of = {"version","id"})
public class PointBo {

    @Version
    @Column(name = "version")
    private Long version;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom", unique = true)
    private String nom;

    public PointBo() {
        super();
    }

    public PointBo(String nom) {
        this.nom = nom;
    }

    public PointBo(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

}
