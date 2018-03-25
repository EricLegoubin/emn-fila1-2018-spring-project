package com.emn.GEO.domain;
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

	private Long idTrain;

	private Set<Sillon> sillons;

	private List<Passage> passages;

	private List<Passage> passagesTheoriques;

	public Course(Long id, Long idTrain, Set<Sillon> sillons,
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
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(passagesTheoriques.size());
		passagesTheoriques.forEach((passage) -> {
			long delay = (passage.getTime().getTime() - System.currentTimeMillis())/100;
			if (delay >= 0) {
				scheduler.schedule(passage, delay, TimeUnit.MILLISECONDS);
			}
		});
	}

	public Long getId() {
		return id;
	}
	
        public void addPerturbationOnPassage(Long poiId, int minutes){
           boolean check = false;
            for(Passage p : passages){
                if(p.getPoi().getId().equals(poiId)){
                    check = true;
                }
                if(check){
                    Calendar cal = Calendar.getInstance();
                    cal.setTimeInMillis(p.getTime().getTime());
                    cal.add(Calendar.MINUTE, minutes);
                    p.setTime(new Timestamp(cal.getTime().getTime()));
                }
            } 
        }
        
        public void addCancelationOnPassage(Long poiId){
            List<Passage> liste = new ArrayList<>();
            for(Passage p : passages){
                if(p.getPoi().getId().equals(poiId)){
                    break;
                }
                liste.add(p);
            }
            passages = liste;
        }

    public Long getIdTrain() {
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
