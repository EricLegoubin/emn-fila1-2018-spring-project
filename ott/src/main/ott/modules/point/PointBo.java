package main.ott.modules.point;

import javax.persistence.*;

@Entity(name = "points")
@Table(name = "points")
public class PointBo {

    @Version
    @Column(name = "version")
    private Long version;

    @Id
    @GeneratedValue
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String toString() {
        return nom + "(" + id + ")";
    }

}
