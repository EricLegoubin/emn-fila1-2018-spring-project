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
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PushStartingCoursesJob {


    @Autowired
    private CourseService courseService;

    private static final Logger log = LoggerFactory.getLogger(PushDailyCousesJob.class);


    ObjectMapper mapperJson = new ObjectMapper();

    @Autowired
    CourseBoDtoMapper mapperCourse;

    @Autowired
    private Sender sender;

    @Scheduled(cron = "0 */5 * ? * *")//task every 5 min
        public void pushCourses() {
        log.info("Sending Starting Courses ");

        List<CourseBo> listCourseBo = getTodaysCourses();
        List<CourseDto> courses = mapperCourse.listBo2Dto(listCourseBo);
        String message = "";
        //Send JSON with all courses to other components
        try {
            message = mapperJson.writeValueAsString(courses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        sender.send("startingCourses",message);

    }


    /**
     * Récupère les course qui commencent dans plus de 5 min et moins de 10.
     * @return
     */
    public List<CourseBo> getTodaysCourses(){
        long nowPlus5 = System.currentTimeMillis() + 300000; //milliseconds in a day
        long nowPlus10 = System.currentTimeMillis() + 600000; //milliseconds in a day
        return courseService.getCourseDtoStartingBetweenDates(new Timestamp(nowPlus5),new Timestamp(nowPlus10));
       }
}
