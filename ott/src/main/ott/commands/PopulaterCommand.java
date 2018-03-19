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

import java.time.LocalDateTime;
import java.util.*;

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
    }

    static {
        sillons.put("s1", new SillonBo(new HashSet<>(Arrays.asList(
                points.get("lyon"),
                points.get("p2")
        ))));
        sillons.put("s2", new SillonBo(new HashSet<PointBo>(Collections.singletonList(points.get("paris")))));
        sillons.put("s3", new SillonBo(new HashSet<PointBo>(Collections.singletonList(points.get("p1")))));
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
