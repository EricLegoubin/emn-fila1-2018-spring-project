package main.ott.modules.point;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of ={"id"})
public class PointDto {

    /**
     * Id du point
     */
    private Long id;
    /**
     * Nom du point si c'est une gare, null sinon.
     */
    private String nom;
    /**
     * Booléen qui représente si le point est une gare.
     */
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
}
