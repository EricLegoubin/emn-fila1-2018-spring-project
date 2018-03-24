package main.ott.service.internalManagement.Job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.ott.kafka.Sender;
import main.ott.modules.course.CourseBo;
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

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private Sender sender;

    @Scheduled(cron = "0 0 1 * * ?")//task scheduled at 1 am
    public void pushCourses() {
        log.info("Sending Today's Courses ");
        RestTemplate restTemplate = new RestTemplate();


        //TODO call DB requete: toutes les courses ou date de départ aujourdui
        //Todo call Mapper
        List<CourseDto> courses = new ArrayList<>();
        String message = "";
        //Send JSON with all courses to other components
        try {
             message = mapper.writeValueAsString(courses);
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
        long timeStamp = System.currentTimeMillis() - 86400000; //milliseconds in a day
        return courseService.getCourseDtoStartingAfterDate(new Timestamp(timeStamp));
    }




    @Scheduled(cron = "* * * ? * *")//task scheduled every secon just to see
    public void cronTest() { 
    	/*
    	System.out.println("Test");
		*/
    }
}
