package com.emn.GEO.kafka;

import java.util.List;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.emn.GEO.GeoApplication;
import com.emn.GEO.domain.Course;
import com.emn.GEO.simulateur.Simulateur;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class Receiver {

	public static Receiver receiver = new Receiver();
	
	private Receiver() {};
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	public CountDownLatch getLatch() {
		return latch;
	}
	
	@KafkaListener(topics="dailyCourse")
	public void receiveMocks(ConsumerRecord<?, ?> cr) throws IOException {
//		Would be used if mocks were transfered as dto, but we need ALL the information here.
//		CourseMapper courseMapper = new CourseMapper();
//		List<Course> coursesToSimulate = courseMapper.courseDTOsToCourses((List<CourseDTO>) cr.value());
		System.out.println("Received mocks : " + cr.value().toString());
                ObjectMapper mapper = new ObjectMapper();
		List<Course> coursesToSimulate = new ArrayList<>(Arrays.asList(mapper.readValue(cr.value().toString(), Course[].class)));
                System.out.println(coursesToSimulate.toString());
		Simulateur simulateur = new Simulateur(coursesToSimulate);
		GeoApplication.setSimulateur(simulateur);
		simulateur.startSimulation();
		latch.countDown();
	}
        
        @KafkaListener(topics="newCourse")
        public void receiveCourse(ConsumerRecord<?, ?> cr) throws IOException{
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Received new course : " + cr.value().toString());
            Course course = mapper.readValue(cr.value().toString(), Course.class) ;
            GeoApplication.getSimulateur().addCourse(course);
            new Thread(course).start();
        }
}
