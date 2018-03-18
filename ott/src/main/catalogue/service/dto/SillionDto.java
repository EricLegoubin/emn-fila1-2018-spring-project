package main.catalogue.service.dto;

import java.util.List;

public class SillionDto {

    private Long id;

    private List<Long> poiIds;

    public SillionDto(Long id, List<Long> poiIds) {

        this.id = id;
        this.poiIds = poiIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getPoiIds() {
        return poiIds;
    }

    public void setPoiIds(List<Long> poiIds) {
        this.poiIds = poiIds;
    }
}
