package main.ott.modules.course;

import main.ott.modules.passage.PassageDto;
import main.ott.modules.sillon.SillonDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseDto {

    private Long id;

    private String idTrain;

    private Set<SillonDto> sillons;

    private Set<PassageDto> computedPassages;
    
    public CourseDto() {
    	super();
    }

    public CourseDto(Long id, String idTrain, Set<SillonDto> sillons, Set<PassageDto> computedPassages) {
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

    public Set<PassageDto> getComputedPassages() {
        return computedPassages;
    }

    public void setComputedPassages(Set<PassageDto> computedPassages) {
        this.computedPassages = computedPassages;
    }

    public Set<SillonDto> getSillons() {
        return sillons;
    }

    public void setSillons(Set<SillonDto> sillons) {
        this.sillons = sillons;
    }

}
