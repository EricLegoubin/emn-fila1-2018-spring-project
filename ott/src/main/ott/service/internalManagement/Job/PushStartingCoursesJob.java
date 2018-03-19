package main.ott.service.internalManagement.Job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.ott.kafka.Sender;
import main.ott.modules.course.CourseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class PushStartingCoursesJob {
    //todo every 10s ? check if course start in the next 10s if yes sends them to projeté


    private static final Logger log = LoggerFactory.getLogger(PushDailyCousesJob.class);

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private Sender sender;

    @Scheduled(cron = "0 */5 * ? * *")//task every 5 min
        public void pushCourses() {
        log.info("Sending Starting Courses ");
        RestTemplate restTemplate = new RestTemplate();

        //TODO call DB requete: toutes les courses qui commence dans les 5min
        //Todo call Mapper
        List<CourseDto> courses = new ArrayList<>();
        String message = "";
        //Send JSON with all courses to other components
        try {
            message = mapper.writeValueAsString(courses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        sender.send("startingCourses",message);

    }
}
