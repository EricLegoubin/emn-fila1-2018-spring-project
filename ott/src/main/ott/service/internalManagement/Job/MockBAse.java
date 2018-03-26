package main.ott.service.internalManagement.Job;

import main.ott.modules.course.CourseBo;
import main.ott.modules.course.CourseDto;
import main.ott.modules.passage.PassageBo;
import main.ott.modules.passage.PassageDto;
import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointDto;
import main.ott.modules.sillon.SillonBo;
import main.ott.modules.sillon.SillonDto;

import java.sql.Timestamp;
import java.util.*;

public class MockBAse {

    private static int it=0;

    public static List<CourseDto> getCourses() {
        return courses;
    }

    private static Map<String, PointDto> points = new HashMap<>();
    private static Map<String, SillonDto> sillons = new HashMap<>();
    private static List<CourseDto> courses = new LinkedList<>();

    static {
        points.put("Lyon", new PointDto(new Long(1),"Lyon", true));
        points.put("P1", new PointDto(new Long(2),"p1", false));
        points.put("P2", new PointDto(new Long(3),"p2", false));
        points.put("Nantes", new PointDto(new Long(4),"Nantes", true));
        points.put("Oudon", new PointDto(new Long(5),"Oudon", false));
        points.put("Ancenis", new PointDto(new Long(6),"Ancenis", false));
        points.put("Chartres", new PointDto(new Long(7),"Chartres", false));
        points.put("Paris", new PointDto(new Long(8),"Paris", true));
    }

    static {
        sillons.put("S1", new SillonDto(new Long(9),new HashSet<>(Arrays.asList(
                points.get("Lyon"),
                points.get("P2")
        ))));

        sillons.put("S2", new SillonDto(new Long(10),new HashSet<>(Collections.singletonList(points.get("Paris")))));

        sillons.put("S3", new SillonDto(new Long(11),new HashSet<>(Collections.singletonList(points.get("P1")))));

        Set<PointDto> s4 = new HashSet<>();
        s4.add(points.get("Nantes"));
        s4.add(points.get("Oudon"));
        s4.add(points.get("Ancenis"));
        sillons.put("S4", new SillonDto(new Long(12),s4));

        Set<PointDto> s5 = new HashSet<>();
        s5.add(points.get("Ancenis"));
        s5.add(points.get("Chartres"));
        s5.add(points.get("Paris"));
        sillons.put("S5", new SillonDto(new Long(13),s5));
    }

    static {
        Timestamp now = new Timestamp(System.currentTimeMillis()+600000);

        CourseDto c1 = new CourseDto();
        c1.setIdTrain("TrainC1");
        c1.setComputedPassages(new ArrayList<>(Arrays.asList(
                new PassageDto(now, points.get("Lyon")),
                new PassageDto(now, points.get("P2")),
                new PassageDto(now, points.get("Paris"))
        )));
        c1.setSillons(new HashSet<>(Arrays.asList(
                sillons.get("S1"),
                sillons.get("S2")
        )));
        courses.add(c1);

        CourseDto c2 = new CourseDto();
        c2.setIdTrain("TrainC2");
        c2.setComputedPassages(new ArrayList<>(Arrays.asList(
                new PassageDto(now, points.get("Nantes")),
                new PassageDto(now, points.get("Oudon")),
                new PassageDto(now, points.get("Ancenis")),
                new PassageDto(now, points.get("Chartres")),
                new PassageDto(now, points.get("Paris"))
        )));
        c2.setSillons(new HashSet<>(Arrays.asList(
                sillons.get("S4"),
                sillons.get("S5")
        )));
        courses.add(c2);

        for (int i = 2; i < 10 ; i++) {
            now = new Timestamp(System.currentTimeMillis()+600000*i);
            CourseDto temp = new CourseDto();
            c2.setIdTrain("TrainC"+i);
            c2.setComputedPassages(new ArrayList<>(Arrays.asList(
                    new PassageDto(now, points.get("Nantes")),
                    new PassageDto(now, points.get("Oudon")),
                    new PassageDto(now, points.get("Ancenis")),
                    new PassageDto(now, points.get("Chartres")),
                    new PassageDto(now, points.get("Paris"))
            )));
            c2.setSillons(new HashSet<>(Arrays.asList(
                    sillons.get("S4"),
                    sillons.get("S5")
            )));
            courses.add(temp);
        }
    }
}
