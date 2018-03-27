package org.imta.fila1.spring.informationgare.course;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseServiceStub extends CourseService {

    private ArrayList<Course> courses;
    private int compteur = 1;

    private static final long tempsAffichageMax = (6 * 60 * 60) * 1000;

    public CourseServiceStub() {

        courses = new ArrayList<>();

        //this.addCourse();

    }

    public void duplicate() {
        this.addCourse();
    }

    public void addRetard(String type) {
        if (type.equals("departs")) {
            this.courses.get(this.courses.size() - 1).setRetardDepart(10);
        } else {
            this.courses.get(this.courses.size() - 1).setRetardArrivee(10);
        }
    }

    @Override
    public List<Course> getDeparts(String aGare) {

        ArrayList<Course> vDeparts = new ArrayList<>();
        for (Course vCourse : courses) {
            if (vCourse.isGareDepart(aGare) && vCourse.getPassageDepart().getTimestamp().before(new Timestamp(System.currentTimeMillis() + tempsAffichageMax))) {
                vDeparts.add(vCourse);
            }
        }
        return vDeparts;
    }

    @Override
    public List<Course> getArrivees(String aGare) {

        ArrayList<Course> vDeparts = new ArrayList<>();
        for (Course vCourse : courses) {
            if (vCourse.isGareArrivee(aGare) && vCourse.getPassageArrivee().getTimestamp().before(new Timestamp(System.currentTimeMillis() + tempsAffichageMax))) {
                vDeparts.add(vCourse);
            }
        }
        return vDeparts;
    }

    public void addCourse() {

        ArrayList<Sillon> vSillons = new ArrayList<>();
        ArrayList<Passage> vPassages = new ArrayList<>();
        ArrayList<POI> vPois = new ArrayList<>();
        Calendar vCalendar = Calendar.getInstance();

        POI vDepart = new POI(1, true, "cholet");
        POI vArret = new POI(2, true, "nantes");
        POI vArrivee = new POI(3, true, "paris");

        vPois.add(vDepart);
        vPois.add(vArret);
        vPois.add(vArrivee);

        vSillons.add(new Sillon(1, vPois));

        vPassages.add(new Passage(new Timestamp(vCalendar.getTimeInMillis() + 2 * 60), 1, vDepart));
        vCalendar.add(Calendar.HOUR_OF_DAY, 1);
        vPassages.add(new Passage(new Timestamp(vCalendar.getTimeInMillis() + 3 * 60 * 60 * 1000), 2, vArret));
        vCalendar.add(Calendar.HOUR_OF_DAY, 1);
        vPassages.add(new Passage(new Timestamp(vCalendar.getTimeInMillis() + 4 * 60 * 60 * 1000), 3, vArrivee));

        Course course = new Course(1, this.compteur, vSillons, vPassages);
        //course.setRetardArrivee(5);
        //course.setRetardDepart(10);
        courses.add(course);

        this.compteur++;
    }

    public void cancel() {
        this.courses.get(this.courses.size() - 1).setCancelled(true);
    }
}
