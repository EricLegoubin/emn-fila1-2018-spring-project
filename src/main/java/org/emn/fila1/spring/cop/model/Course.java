package org.emn.fila1.spring.cop.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Train move. 
 * 
 * @see <a href="https://docs.spring.io/spring-data/redis/docs/2.0.5.RELEASE/reference/html/#redis.repositories.usage">RedisHash annotation usage</a>
 */
@RedisHash("courses")
public class Course implements Serializable {

	private static final long serialVersionUID = -4714046246775782028L;
	
	@Id
	private String id;
	
	/**
	 * Any respectful POJO needs a default constructor.
	 */
	public Course() {
		super();
	}

	public Course(String id) {
		this.id = id;
	}

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
	
	/* TODO - MODEL */
}
