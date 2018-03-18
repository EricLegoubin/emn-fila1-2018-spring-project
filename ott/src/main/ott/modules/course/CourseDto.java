package main.ott.modules.course;

import main.ott.modules.passage.PassageDto;
import main.ott.modules.sillon.SillionDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseDto {

    private Long id;

    private String idTrain;

    private Set<SillionDto> sillons;

    private Set<PassageDto> computedPassages;

    public CourseDto(Long id, String idTrain, Set<SillionDto> sillons, Set<PassageDto> computedPassages) {
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

    public Set<SillionDto> getSillons() {
        return sillons;
    }

    public void setSillons(Set<SillionDto> sillons) {
        this.sillons = sillons;
    }

}
