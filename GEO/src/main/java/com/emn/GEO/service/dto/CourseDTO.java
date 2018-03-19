package com.emn.GEO.service.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseDTO {

    private Long id;

    private String idTrain;

    private Set<SillonDTO> sillons;

    private List<PassageDTO> computedPassages;
    
    public CourseDTO() {
    	super();
    }

    public CourseDTO(Long id, String idTrain, Set<SillonDTO> sillons, List<PassageDTO> computedPassages) {
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

    public List<PassageDTO> getComputedPassages() {
        return computedPassages;
    }

    public void setComputedPassages(List<PassageDTO> computedPassages) {
        this.computedPassages = computedPassages;
    }

    public Set<SillonDTO> getSillons() {
        return sillons;
    }

    public void setSillons(Set<SillonDTO> sillons) {
        this.sillons = sillons;
    }

}