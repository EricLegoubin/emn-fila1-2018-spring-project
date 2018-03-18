package main.ott.commands;

import main.ott.modules.point.PointDto;
import main.ott.modules.point.PointService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class HibernateTest {

    private PointService pointService;

    @Autowired
    public HibernateTest(PointService pointService) {
        this.pointService = pointService;
    }

    @ShellMethod("test")
    public void test(Long id) {
        PointDto point = pointService.getPoint(id);
        System.out.println(point);
    }

}
