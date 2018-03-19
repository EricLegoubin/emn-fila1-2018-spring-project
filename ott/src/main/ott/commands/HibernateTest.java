package main.ott.commands;

import main.ott.modules.course.CourseDto;
import main.ott.modules.passage.PassageDto;
import main.ott.modules.passage.PassageDto;
import main.ott.modules.point.PointDto;
import main.ott.modules.point.PointDto;
import main.ott.modules.point.PointService;
import main.ott.modules.sillon.SillonDto;
import main.ott.modules.sillon.SillonDto;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ShellComponent
public class HibernateTest {

    private SessionFactory sessionFactory;
    private PointService pointService;

    @Autowired
    public HibernateTest(PointService pointService, SessionFactory sessionFactory) {
        this.pointService = pointService;
        this.sessionFactory = sessionFactory;
    }

    @ShellMethod("test")
    public void test(Long id) {
        Optional<PointDto> point = pointService.getById(id);
        System.out.println(point.isPresent() ? point.get() : "Aucun résultat");
    }
    
    @ShellMethod("populate")
    public void populate() {
    	Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    String[] tables = new String[]{"courses", "sillons", "passages", "points"};
	
	    for (String s : tables) {
	        System.out.println("Deleting table " + s);
	        String q = String.format("delete from %s", s);
	        Query query = session.createQuery(q);
	        query.executeUpdate();
	    }
	
	    PointDto p1 = new PointDto();
	    p1.setNom("Lyon");
	    PointDto p2 = new PointDto();
	    p2.setNom("Paris");
	    PointDto p3 = new PointDto();
	    p3.setNom("Marseille");
	    
	    pointService.create(p1);
	    pointService.create(p2);
	    pointService.create(p3);
	
	    SillonDto s1 = new SillonDto();
	    SillonDto s2 = new SillonDto();
	
	    Set<PointDto> points1 = new HashSet<>();
	    Set<PointDto> points2 = new HashSet<>();
	    points1.add(p1);
	    points1.add(p2);
	    points2.add(p2);
	    points2.add(p3);
	    s1.setPoints(points1);
	    s2.setPoints(points2);
	
	    session.save(s1);
	    session.save(s2);
	
	    Timestamp timestamp = Timestamp.from(Instant.now());
	    PassageDto pass1 = new PassageDto();
	    pass1.setPoint(p1);
	    pass1.setLocalDateTime(timestamp);
	    
	    PassageDto pass2 = new PassageDto();
	    pass2.setPoint(p2);
	    timestamp.setMinutes(timestamp.getMinutes()+5);
	    pass2.setLocalDateTime(timestamp);
	    
	    PassageDto pass3 = new PassageDto();
	    pass3.setPoint(p3);
	    timestamp.setMinutes(timestamp.getMinutes()+5);
	    pass3.setLocalDateTime(timestamp);
	
	    session.save(pass1);
	    session.save(pass2);
	    session.save(pass3);
	
	    CourseDto course1 = new CourseDto();
	    course1.setIdTrain("124578");
	
	    List<PassageDto> passages1 = new ArrayList<>();
	    passages1.add(pass1);
	    passages1.add(pass2);
	    passages1.add(pass3);
	    Set<SillonDto> sillons1 = new HashSet<>();
	    sillons1.add(s1);
	    sillons1.add(s2);
	
	    course1.setComputedPassages(passages1);
	    course1.setSillons(sillons1);
	
	    session.save(course1);
	    
	    session.getTransaction().commit();

    }

}
