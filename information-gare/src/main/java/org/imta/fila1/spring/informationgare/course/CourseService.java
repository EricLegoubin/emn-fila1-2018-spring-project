package org.imta.fila1.spring.informationgare.course;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Classe Service des courses
 * 
 * @author Cédric GARCIA
 *
 */
@Service
public class CourseService {

	public static CourseRepository courseRepository = new SimpleCourseRepository();
	// @Autowired
	// CourseRepository courseRepository;

	/*
	 * Correspond au décalage de l'affichage <br/> Un train partant à 11h00 est
	 * affiché jusqu'a 11h05. Un train arrivant a 12h00 est affiché jusqu'à 12h05
	 * 
	 */
	public final long DELTA_T = 300000;// ~ 5 minutes

	private static final long tempsAffichageMax = (6 * 60 * 60) * 1000;

	public List<Course> getDeparts(String aGare) {

		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse : courseRepository.findAll()) {

			if (vCourse.isGareDepart(aGare) && isSuitableForDeparture(vCourse)) {
				vDeparts.add(vCourse);
			}
		}
		return vDeparts;
	}

	/**
	 * Renvoie true si la course doit être affichée sur le panneau d'affichage des
	 * départs
	 * 
	 * @param course
	 *            la course que l'on souhaite afficher
	 * @return true si la course doit être affichée sur le panneau d'affichage des
	 *         départs
	 */
	private boolean isSuitableForDeparture(Course course) {
		return course.getPassageDepart().getTimestamp()
				.before(new Timestamp(System.currentTimeMillis() + tempsAffichageMax))
				&& course.getPassageDepart().getTimestamp().getTime() > System.currentTimeMillis() - DELTA_T;
	}

	/**
	 * Renvoie true si la course doit être affichée sur le panneau d'affichage des
	 * départs
	 * 
	 * @param course
	 *            la course que l'on souhaite afficher
	 * @return true si la course doit être affichée sur le panneau d'affichage des
	 *         départs
	 */
	private boolean isSuitableForArrival(Course course) {
		return course.getPassageArrivee().getTimestamp()
				.before(new Timestamp(System.currentTimeMillis() + tempsAffichageMax))
				&& course.getPassageArrivee().getTimestamp().getTime() > System.currentTimeMillis() - DELTA_T;
	}

	public List<Course> getArrivees(String aGare) {

		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse : courseRepository.findAll()) {

			if (vCourse.isGareArrivee(aGare) && isSuitableForArrival(vCourse)) {
				vDeparts.add(vCourse);
			}
		}
		return vDeparts;
	}

	// public Course getCourse(String id) {
	//
	// return courseRepository.findOne(id);
	// }

	public void addCourse(Course course) {
		courseRepository.add(course);
	}

	// public void updateCourse(Course course) {
	//
	// courseRepository.save(course);
	// }
	//
	// public void deleteCourse(String id) {
	//
	// courseRepository.delete(id);
	// }

	public int countEntries() {
		return courseRepository.countEntries();
	}

    public void duplicate() {
    }

	public void addRetard(String type) {
	}

	public void cancel() { }
}
