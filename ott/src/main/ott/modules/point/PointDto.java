package main.ott.modules.point;

public class PointDto {

    private Long id;

    private String nom;

    private boolean isGare;


    public PointDto() {
        super();
    }

    public PointDto(Long id, String nom, boolean isGare) {
        super();
        this.id = id;
        this.nom = nom;
        this.isGare = isGare;
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

    public String toString() {
        return nom + "(" + id + ")";
    }

    public boolean isGare() {
        return isGare;
    }

    public void setGare(boolean gare) {
        isGare = gare;
    }
}
