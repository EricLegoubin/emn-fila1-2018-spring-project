package com.emn.GEO.domain;

import com.emn.GEO.simulateur.FasterSystemClock;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Course implements Runnable {

    private Long id;

    private String idTrain;

    private Set<Sillon> sillons;

    private List<Passage> passages;

    private List<Passage> passagesTheoriques;

    public Course(Long id, String idTrain, Set<Sillon> sillons, List<Passage> passages, List<Passage> passagesTheoriques) {
        this.id = id;
        this.idTrain = idTrain;
        this.sillons = sillons;
        this.passages = passages;
        this.passagesTheoriques = passagesTheoriques;
    }

    public Course() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdTrain(String idTrain) {
        this.idTrain = idTrain;
    }

    public void setSillons(Set<Sillon> sillons) {
        this.sillons = sillons;
    }

    public void setPassages(List<Passage> passages) {
        this.passages = passages;
    }

    @JsonProperty("computedPassages")
    public void setPassagesTheoriques(List<Passage> passagesTheoriques) {
        this.passagesTheoriques = passagesTheoriques;
    }

    public Course(Long id, String idTrain, Set<Sillon> sillons,
            List<Passage> passagesTheoriques) {
        super();
        this.id = id;
        this.idTrain = idTrain;
        this.sillons = sillons;
        this.passages = passagesTheoriques;
        this.passagesTheoriques = passagesTheoriques;
    }

    @Override
    public void run() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10000);
        try {
            if(passagesTheoriques != null && passagesTheoriques.size() > 0)
            {
            for (Passage passage : passagesTheoriques) {

                long delay = (passage.getTimestamp().getTime() - FasterSystemClock.clock.getTime());
                if (delay >= 0) {
                    scheduler.schedule(passage, delay, TimeUnit.MILLISECONDS);

                }
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void addPerturbationOnPassage(Long poiId, int minutes) {
        boolean check = false;
        for (Passage p : passages) {
            if (p.getPoi().getId().equals(poiId)) {
                check = true;
            }
            if (check) {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(p.getTimestamp().getTime());
                cal.add(Calendar.MINUTE, minutes);
                p.setTimestamp(new Timestamp(cal.getTime().getTime()));
            }
        }
    }

    public void addCancelationOnPassage(Long poiId) {
        List<Passage> liste = new ArrayList<>();
        for (Passage p : passages) {
            if (p.getPoi().getId().equals(poiId)) {
                break;
            }
            liste.add(p);
        }
        passages = liste;
    }

    public String getIdTrain() {
        return idTrain;
    }

    public Set<Sillon> getSillons() {
        return sillons;
    }

    public List<Passage> getPassages() {
        return passages;
    }

    public List<Passage> getPassagesTheoriques() {
        return passagesTheoriques;
    }

}
