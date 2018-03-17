package com.emn.GEO.domain;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Course implements Runnable {

	private Long id;

	private String idTrain;

	private List<Sillon> sillons;

	private List<Passage> passages;

	private List<Passage> passagesTheoriques;

	public Course(Long id, String idTrain, List<Sillon> sillons, List<Passage> passages,
			List<Passage> passagesTheoriques) {
		super();
		this.id = id;
		this.idTrain = idTrain;
		this.sillons = sillons;
		this.passages = passages;
		this.passagesTheoriques = passagesTheoriques;
	}

	@Override
	public void run() {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(passagesTheoriques.size());
		passagesTheoriques.forEach((passage) -> {
			long delay = passage.getTime().getTimestamp().getTime() - System.currentTimeMillis();
			if (delay >= 0) {
				scheduler.schedule(passage, delay, TimeUnit.MILLISECONDS);
			}
		});
	}

	public Long getId() {
		return id;
	}
	
//	public void addPerturbationOnPassage(Long poiId)
//	{
//		for(Passage passage : passages)
//		{
//			if(passage.getPoi().getId() == poiId)
//			{
//				
//				break;
//			}
//		}
//	}

}
