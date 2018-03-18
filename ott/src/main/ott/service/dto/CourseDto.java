package main.ott.service.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class CourseDto {
    private Long id;

    private String idTrain;

    private List<Long> sillonIds;

    private Map<Long,LocalDateTime> computedPassages;


    public CourseDto(Long id, String idTrain, List<Long> sillonIds,Map<Long,LocalDateTime> points) {
        super();
        this.id = id;
        this.idTrain = idTrain;
        this.sillonIds = sillonIds;
        this.computedPassages = points;
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

    public List<Long> getSillonIds() {
        return sillonIds;
    }

    public void setSillonIds(List<Long> sillonIds) {
        this.sillonIds = sillonIds;
    }

    public Map<Long, LocalDateTime> getComputedPassages() {
        return computedPassages;
    }

    public void setComputedPassages(Map<Long, LocalDateTime> computedPassages) {
        this.computedPassages = computedPassages;
    }
}
