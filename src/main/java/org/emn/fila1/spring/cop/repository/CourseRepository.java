package org.emn.fila1.spring.cop.repository;

import org.emn.fila1.spring.cop.model.CourseCOP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @see <a href="https://docs.spring.io/spring-data/redis/docs/2.0.5.RELEASE/reference/html/#redis.repositories">Redis Repositories</a>
 *
 */
@Repository
public interface CourseRepository extends CrudRepository<CourseCOP, String> {
}
