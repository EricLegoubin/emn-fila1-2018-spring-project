package main.ott.service.internalManagement.Job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.ott.kafka.Sender;
import main.ott.modules.course.CourseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class PushNewCoursesJob {
    private static final Logger log = LoggerFactory.getLogger(PushDailyCousesJob.class);
    private final String uri = "urlto";
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private Sender sender;
    //todo when externalmanagement recieve new course, put them in the base then call this

    public void pushCourses(CourseDto courseDto) {
        log.info("Sending New Course ");

        String message = "";
        //Send JSON with all courses to other components
        try {
            message = mapper.writeValueAsString(courseDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        sender.send("New Course",message);

    }
}
