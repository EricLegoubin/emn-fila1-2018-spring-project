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
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class PushNewCoursesJob {

    @Autowired
    private CourseService courseService;
    private static final Logger log = LoggerFactory.getLogger(PushDailyCousesJob.class);
    ObjectMapper mapperJson = new ObjectMapper();

    @Autowired
    CourseBoDtoMapper mapperCourse;

    @Autowired
    private Sender sender;

    /**
     * Called by externalManagement.CourceSevices when a course has been updated, have to check if the course has been given to others services to alert them, else, do normal treatments.
     */
    public void pushCoursesForUpdatedCourse(CourseDto courses) {
        log.info("Sending New Course ");
        String message = "";
        //Send JSON with all courses to other components
        try {
            message = mapperJson.writeValueAsString(courses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        sender.send("updateCourse",message);
    }

    /**
     * Called by externalManagement.CourceSevices when a totally new course comes in the OTT service (like a new POST from the prospect service).
     */
    public void pushCoursesForNewCourse(CourseDto courses) {
        log.info("Sending New Course ");
        String message = "";
        //Send JSON with all courses to other components
        try {
            message = mapperJson.writeValueAsString(courses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        sender.send("newCourse",message);

    }
}
