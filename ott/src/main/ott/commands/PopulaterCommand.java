package main.ott.commands;

import main.ott.modules.base.Service;
import main.ott.modules.course.CourseBo;
import main.ott.modules.course.CourseService;
import main.ott.modules.passage.PassageBo;
import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointService;
import main.ott.modules.sillon.SillonBo;
import main.ott.modules.sillon.SillonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.sql.Timestamp;
import java.util.*;

@ShellComponent
public class PopulaterCommand {

    private static Map<String, PointBo> points = new HashMap<>();
    private static Map<String, SillonBo> sillons = new HashMap<>();
    private static List<CourseBo> courses = new LinkedList<>();

    static {
        points.put("Lyon", new PointBo("Lyon", true));
        points.put("P1", new PointBo("p1", false));
        points.put("P2", new PointBo("p2", false));
        points.put("Nantes", new PointBo("Nantes", true));
        points.put("Oudon", new PointBo("Oudon", false));
        points.put("Ancenis", new PointBo("Ancenis", false));
        points.put("Chartres", new PointBo("Chartres", false));
        points.put("Paris", new PointBo("Paris", true));
    }

    static {
        sillons.put("S1", new SillonBo(new HashSet<>(Arrays.asList(
                points.get("Lyon"),
                points.get("P2")
        ))));

        sillons.put("S2", new SillonBo(new HashSet<>(Collections.singletonList(points.get("Paris")))));

        sillons.put("S3", new SillonBo(new HashSet<>(Collections.singletonList(points.get("P1")))));

        Set<PointBo> s4 = new HashSet<>();
        s4.add(points.get("Nantes"));
        s4.add(points.get("Oudon"));
        s4.add(points.get("Ancenis"));
        sillons.put("S4", new SillonBo(s4));

        Set<PointBo> s5 = new HashSet<>();
        s5.add(points.get("Ancenis"));
        s5.add(points.get("Chartres"));
        s5.add(points.get("Paris"));
        sillons.put("S5", new SillonBo(s5));
    }

    static {
        Timestamp now = new Timestamp(System.currentTimeMillis() + 600000);

        CourseBo c1 = new CourseBo();
        c1.setIdTrain("TrainC1");
        c1.setComputedPassages(new HashSet<>(Arrays.asList(
                new PassageBo(now, points.get("Lyon")),
                new PassageBo(now, points.get("P2")),
                new PassageBo(now, points.get("Paris"))
        )));
        c1.setSillons(new HashSet<>(Arrays.asList(
                sillons.get("S1"),
                sillons.get("S2")
        )));
        courses.add(c1);

        CourseBo c2 = new CourseBo();
        c2.setIdTrain("TrainC2");
        c2.setComputedPassages(new HashSet<>(Arrays.asList(
                new PassageBo(now, points.get("Nantes")),
                new PassageBo(now, points.get("Oudon")),
                new PassageBo(now, points.get("Ancenis")),
                new PassageBo(now, points.get("Chartres")),
                new PassageBo(now, points.get("Paris"))
        )));
        c2.setSillons(new HashSet<>(Arrays.asList(
                sillons.get("S4"),
                sillons.get("S5")
        )));
        courses.add(c2);
    }

    private CourseService courseService;
    private PointService pointService;
    private SillonService sillonService;

    @Autowired
    public PopulaterCommand(CourseService courseService, PointService pointService, SillonService sillonService) {
        this.courseService = courseService;
        this.pointService = pointService;
        this.sillonService = sillonService;
    }

    private <T> void createWithService(Service<T> service, Collection<T> items) {
        for (T item : items) {
            service.create(item);
        }
    }

    @SuppressWarnings("unused")
    @ShellMethod("Remplit la base de données avec des données de test")
    public void populate() {
        createWithService(pointService, points.values());
        createWithService(sillonService, sillons.values());
        createWithService(courseService, courses);
    }

    @SuppressWarnings("unused")
    @ShellMethod("Teste l'affichage de courses")
    public void showcourses() {
        Timestamp now = new Timestamp(System.currentTimeMillis() - (long) 3.6e6);
        List<CourseBo> courses = courseService.getCourseDtoStartingAfterDate(now);
        System.out.println(courses.size());
    }

}
