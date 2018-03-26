package com.emn.GEO.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;

public class Sillon {

    private Long id;
	
    
    private Set<POI> pois;

    public Sillon() {
    }

        
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<POI> getPois() {
        return pois;
    }
    @JsonProperty("points")
    public void setPois(Set<POI> pois) {
        this.pois = pois;
    }

        
        
	public Sillon(Long id, Set<POI> pois) {
		super();
		this.id = id;
		this.pois = pois;
	}
	
}
