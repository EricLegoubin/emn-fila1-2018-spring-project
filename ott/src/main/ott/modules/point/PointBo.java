package main.ott.modules.point;

import javax.persistence.*;

@Entity
@Table(name = "point")
public class PointBo {

    @Version
    @Column(name = "version")
    private Long version;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

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

}
