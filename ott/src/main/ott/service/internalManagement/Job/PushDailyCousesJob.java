package main.ott.service.internalManagement.Job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.ott.kafka.Sender;
import main.ott.modules.course.CourseBo;
import main.ott.modules.course.CourseBoDtoMapper;
import main.ott.modules.course.CourseDto;
import main.ott.modules.course.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PushDailyCousesJob {


    @Autowired
    private CourseService courseService;

    private static final Logger log = LoggerFactory.getLogger(PushDailyCousesJob.class);


    ObjectMapper mapperJson = new ObjectMapper();

    @Autowired
    CourseBoDtoMapper mapperCourse;

    @Autowired
    private Sender sender;

    @Scheduled(cron = "0 0 1 * * ?")//task scheduled at 1 am
    public void pushCourses() {
        log.info("Sending Today's Courses ");
        List<CourseBo> listCourseBo = getTodaysCourses();
        List<CourseDto> courses = mapperCourse.listBo2Dto(listCourseBo);
        String message = "";
        //Send JSON with all courses to other components
        try {
             message = mapperJson.writeValueAsString(courses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        sender.send("dailyCourse",message);

    }

    public List<CourseBo> getAllCourses(){
        long timeStamp = 0;
        return courseService.getCourseDtoStartingAfterDate(new Timestamp(timeStamp));
    }

    public List<CourseBo> getTodaysCourses(){
        long now = System.currentTimeMillis(); //milliseconds in a day
        long tomorrow = System.currentTimeMillis()  + 86400000 ; //milliseconds in a day
        return courseService.getCourseDtoStartingBetweenDates(new Timestamp(now),new Timestamp(tomorrow));
    }



}
