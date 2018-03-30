package org.imta.fila1.spring.informationgare.converter;

import java.sql.Timestamp;
import java.util.Set;
import java.util.concurrent.LinkedTransferQueue;

import org.imta.fila1.spring.informationgare.course.Course;
import org.imta.fila1.spring.informationgare.course.CourseRepository;
import org.imta.fila1.spring.informationgare.course.CourseService;
import org.imta.fila1.spring.informationgare.modele.maj.MajObject;

public class MajToCourseConverter implements Runnable {

	LinkedTransferQueue<MajObject> queue;

	CourseRepository courseService;

	public MajToCourseConverter(LinkedTransferQueue<MajObject> queue) {
		super();
		this.queue = queue;
		courseService = CourseService.courseRepository;
	}

	@Override
	public void run() {
		while (true) {
			MajObject currentCourse;
			try {
				currentCourse = queue.take();
				System.out.println("COurseMAJ RECUE");
				convert(currentCourse);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void convert(MajObject courseCatalogue) {
		System.out.println("Appel Convert");
		Set<Course> listCourse = courseService.findAll();
		System.out.println("SetCourse: " + listCourse);
		Course course = null;
		for (Course c : listCourse) {
			System.out.println(c.getIdCourse());
			if (c.getIdCourse() == courseCatalogue.getCourseId()) {
				course = c;
				break;
			}
		}
		if (course != null) {
			System.out.println("courseId found : " + course.getIdCourse());
			Timestamp horairePrevu = course.getPassageDepart().getTimestamp();
			System.out.println("horaire prevu: " + horairePrevu);
			Timestamp horaireMaj = courseCatalogue.getCalculatedDate();
			System.out.println("horaireMaj: " + horaireMaj);
			long diff = (horaireMaj.getTime() - horairePrevu.getTime()) / 1000 / 60;
			System.out.println("diff: " + diff);
			course.setRetardDepart(((int) diff));

		}
		// if(courseCatalogue.isCancelled())
		// course.

	}

}
