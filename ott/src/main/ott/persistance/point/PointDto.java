package main.ott.persistance.point;

public class PointDto {

    private Long id;



    private String nom;
    
    public PointDto() {
    	super();
    }

    public PointDto(Long id, String nom) {
        super();
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
}
