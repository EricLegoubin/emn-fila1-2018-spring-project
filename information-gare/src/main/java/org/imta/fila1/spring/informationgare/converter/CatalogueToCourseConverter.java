package org.imta.fila1.spring.informationgare.converter;

import java.util.concurrent.LinkedTransferQueue;

import org.emn.messageBroker.CatalogueConsumer;
import org.imta.fila1.spring.informationgare.course.Course;
import org.imta.fila1.spring.informationgare.course.CourseRepository;
import org.imta.fila1.spring.informationgare.course.CourseService;
import org.imta.fila1.spring.informationgare.modele.catalogue.CourseCatalogue;

/**
 * Convert les objets courses reçus du catalogue en objet course expoitable par
 * notre module
 * 
 * @see CatalogueConsumer
 * @author valentin
 *
 */
public class CatalogueToCourseConverter implements Runnable {

	LinkedTransferQueue<CourseCatalogue> queue;

	CourseRepository courseService;

	public CatalogueToCourseConverter(LinkedTransferQueue<CourseCatalogue> queue) {
		super();
		this.queue = queue;
		courseService = CourseService.courseRepository;
	}

	@Override
	public void run() {
		while (true) {
			try {
				CourseCatalogue currentCourse = queue.take();
				convert(currentCourse);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void convert(CourseCatalogue courseCatalogue) {
		Course courseExploitable = new Course(courseCatalogue.getIdCourse(), courseCatalogue.getNumTrain(),
				courseCatalogue.getListSillons(), courseCatalogue.getListPassages());
		courseService.add(courseExploitable);
	}

}
