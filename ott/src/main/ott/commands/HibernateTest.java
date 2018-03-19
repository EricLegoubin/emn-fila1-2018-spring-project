package main.ott.commands;

import main.ott.modules.course.CourseBo;
import main.ott.modules.passage.PassageBo;
import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointDto;
import main.ott.modules.point.PointService;
import main.ott.modules.sillon.SillonBo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class HibernateTest {
	
	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
    private PointService pointService;

    @ShellMethod("test")
    public void test(Long id) {
        PointDto point = pointService.getPoint(id);
        System.out.println(point);
    }
    
    @ShellMethod("populate")
    public void populate() {
    	Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		String[] tables = new String[] {"courses", "sillons", "passages", "points"};
		
		for(String s:tables) {
			System.out.println("Deleting table "+s);
			String q = String.format("delete from %s",s);
			Query query = session.createQuery(q);
			query.executeUpdate();
		}


		PointBo p1 = new PointBo("Lyon");
		PointBo p2 = new PointBo("Paris");
		PointBo p3 = new PointBo("Marseille");

		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		SillonBo s1 = new SillonBo();
		SillonBo s2 = new SillonBo();
		
		Set<PointBo> points1 = new HashSet<>();
		Set<PointBo> points2 = new HashSet<>();
		points1.add(p1);
		points1.add(p2);
		points2.add(p2);
		points2.add(p3);
		s1.setPoints(points1);
		s2.setPoints(points2);
		
		session.save(s1);
		session.save(s2);
		
		LocalDateTime datetime = LocalDateTime.now();
		PassageBo pass1 = new PassageBo();
		pass1.setPoint(p1);
		pass1.setLocalDateTime(datetime);
		PassageBo pass2 = new PassageBo();
		pass2.setPoint(p2);
		pass2.setLocalDateTime(datetime.plusMinutes(5L));
		PassageBo pass3 = new PassageBo();
		pass3.setPoint(p3);
		pass3.setLocalDateTime(datetime.plusMinutes(10L));
		
		session.save(pass1);
		session.save(pass2);
		session.save(pass3);
		
		CourseBo course1 = new CourseBo();
		course1.setIdTrain("124578");
		
		Set<PassageBo> passages1 = new HashSet<>();
		passages1.add(pass1);
		passages1.add(pass2);
		passages1.add(pass3);
		Set<SillonBo> sillons1 = new HashSet<>();
		sillons1.add(s1);
		sillons1.add(s2);
		
		course1.setComputedPassages(passages1);
		course1.setSillons(sillons1);
		
		session.save(course1);
		
		session.getTransaction().commit();
		
    }

}
