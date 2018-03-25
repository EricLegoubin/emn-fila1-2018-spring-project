package main.ott.commands;

import main.ott.modules.course.CourseBo;
import main.ott.modules.course.CourseService;
import main.ott.modules.passage.PassageBo;
import main.ott.modules.passage.PassageService;
import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointService;
import main.ott.modules.sillon.SillonBo;
import main.ott.modules.sillon.SillonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@ShellComponent
public class PopulaterCommand {

    private static Map<String, PointBo> points = new HashMap<>();
    private static Map<String, SillonBo> sillons = new HashMap<>();
    private static List<CourseBo> courses = new LinkedList<>();

    static {
        points.put("lyon", new PointBo("Lyon", true));
        points.put("paris", new PointBo("Paris", true));
        points.put("p1", new PointBo("p1", false));
        points.put("p2", new PointBo("p2", false));
        points.put("Nantes", new PointBo("Nantes", true));
        points.put("Oudon", new PointBo("Oudon", false));
        points.put("Ancenis", new PointBo("Ancenis", false));
        points.put("Chartres", new PointBo("Chartres", false));
        points.put("Paris", new PointBo("Paris", true));
    }

    static {
        sillons.put("s1", new SillonBo(new HashSet<>(Arrays.asList(
                points.get("lyon"),
                points.get("p2")
        ))));
        sillons.put("s2", new SillonBo(new HashSet<PointBo>(Collections.singletonList(points.get("paris")))));
        sillons.put("s3", new SillonBo(new HashSet<PointBo>(Collections.singletonList(points.get("p1")))));
        HashSet<PointBo> s4 = new HashSet<>();
        s4.add(points.get("Nantes"));
        s4.add(points.get("Oudon"));
        s4.add(points.get("Ancenis"));
        sillons.put("s4", new SillonBo(s4));
        HashSet<PointBo> s5 = new HashSet<>();
        s5.add(points.get("Ancenis"));
        s5.add(points.get("Chartres"));
        s5.add(points.get("Paris"));
        sillons.put("s5", new SillonBo(s5));

    }

    static {
        LocalDateTime now = LocalDateTime.now();

        CourseBo c1 = new CourseBo();
        c1.setIdTrain("train_c1");
        c1.setComputedPassages(new HashSet<>(Arrays.asList(
                new PassageBo(now, points.get("lyon")),
                new PassageBo(now, points.get("p2")),
                new PassageBo(now, points.get("paris"))
        )));
        c1.setSillons(new HashSet<>(Arrays.asList(
                sillons.get("s1"),
                sillons.get("s2")
        )));
        courses.add(c1);

        CourseBo c2 = new CourseBo();
        c2.setIdTrain("train_c2");
        c2.setComputedPassages(new HashSet<>(Arrays.asList(
                new PassageBo(now, points.get("Nantes")),
                new PassageBo(now, points.get("Oudon")),
                new PassageBo(now, points.get("Ancenis")),
                new PassageBo(now, points.get("Chartres")),
                new PassageBo(now, points.get("Paris"))
        )));
        c2.setSillons(new HashSet<>(Arrays.asList(
                sillons.get("s4"),
                sillons.get("s5")
        )));
        courses.add(c2);
    }

    private CourseService courseService;
    private PointService pointService;
    private SillonService sillonService;
    private PassageService passageService;

    @Autowired
    public PopulaterCommand(CourseService courseService, PointService pointService, SillonService sillonService, PassageService passageService) {
        this.courseService = courseService;
        this.pointService = pointService;
        this.sillonService = sillonService;
        this.passageService = passageService;
    }

    @ShellMethod("populate")
    public void populate() {

        for (PointBo point : points.values()) {
            pointService.create(point);
        }
        for (SillonBo sillon : sillons.values()) {
            sillonService.create(sillon);
        }
        courseService.create(courses.get(0));

    }
}
