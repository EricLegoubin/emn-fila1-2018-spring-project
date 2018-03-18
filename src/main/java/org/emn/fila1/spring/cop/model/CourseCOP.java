package org.emn.fila1.spring.cop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RedisHash("courses")
public class CourseCOP implements Serializable {


    private static final long serialVersionUID = -4260410438895819689L;

    @Id
    private String id;
    private List<PassageCOP> passages;
    private List<Sillon> sillons;
    private String numTrain;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    public List<PassageCOP> getPassages() {
        return passages;
    }

    public void setPassages(List<PassageCOP> passages) {
        this.passages = passages;
    }

    public List<Sillon> getSillons() {
        return sillons;
    }

    public void setSillons(List<Sillon> sillons) {
        this.sillons = sillons;
    }

    public String getNumTrain() {
        return numTrain;
    }

    public void setNumTrain(String numTrain) {
        this.numTrain = numTrain;
    }


    /**
     * Any respectful POJO needs a default constructor.
     */
    public CourseCOP() {
        super();
    }


    public CourseCOP(Course course) {
        this.id = course.getId();
        this.numTrain = course.getNumTrain();
        this.sillons = course.getSillons();
        this.passages = new ArrayList<PassageCOP>();
        for (Passage p : course.getPassages()) {
            this.passages.add(new PassageCOP(p));
        }

    }
}
