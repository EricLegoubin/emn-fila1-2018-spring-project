package main.ott.modules.course;

import main.ott.modules.passage.PassageDto;
import main.ott.modules.sillon.SillonDto;

import java.util.List;
import java.util.Set;

public class CourseDto {

    /**
     * Id de la course.
     */
    private Long id;
    /**
     * Id du train relié à la course.
     */
    private String idTrain;
    /**
     * Les sillions de la course
      */
    private Set<SillonDto> sillons;
    /**
     * Les passages faits par la course.
     */
    private List<PassageDto> computedPassages;

    public CourseDto() {
    	super();
    }

    public CourseDto(Long id, String idTrain, Set<SillonDto> sillons, List<PassageDto> computedPassages) {
        super();
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

    public Set<SillonDto> getSillons() {
        return sillons;
    }

    public void setSillons(Set<SillonDto> sillons) {
        this.sillons = sillons;
    }

    public List<PassageDto> getComputedPassages() {
        return computedPassages;
    }

    public void setComputedPassages(List<PassageDto> computedPassages) {
        this.computedPassages = computedPassages;
    }
}
