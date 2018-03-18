package org.emn.fila1.spring.cop.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Train move. 
 * 
 * @see <a href="https://docs.spring.io/spring-data/redis/docs/2.0.5.RELEASE/reference/html/#redis.repositories.usage">RedisHash annotation usage</a>
 */

public class Course implements Serializable {

	private static final long serialVersionUID = -4714046246775782028L;

	@Id
	private String id;
	private List<Passage> passages;
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

	public List<Passage> getPassages() {
		return passages;
	}

	public void setPassages(List<Passage> passages) {
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
	public Course() {
		super();
	}


	public Course(String id) {
		this.id = id;
	}

	public Course(String id, List<Passage> passages, List<Sillon> sillons, String numTrain) {
		this.id = id;
		this.passages = passages;
		this.sillons = sillons;
		this.numTrain = numTrain;
	}
}
