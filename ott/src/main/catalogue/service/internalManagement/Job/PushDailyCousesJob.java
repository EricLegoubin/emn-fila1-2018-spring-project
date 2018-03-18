package main.catalogue.service.internalManagement.Job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PushDailyCousesJob {

    private static final Logger log = LoggerFactory.getLogger(PushDailyCousesJob.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0 0 1 * * ?")//task scheduled at 1 am
    public void pushCourses() {
        log.info("Sending Today's Courses ");
        //Send JSON with all courses to other components

    }




    @Scheduled(cron = "* * * ? * *")//task scheduled at 1 am
    public void cronTest() {
        System.out.println(new Date());

    }
}
