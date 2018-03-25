package com.emn.GEO.kafka;

import java.util.List;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.emn.GEO.GeoApplication;
import com.emn.GEO.domain.Course;
import com.emn.GEO.simulateur.Simulateur;

@Component
public class Receiver {

	public static Receiver receiver = new Receiver();
	
	private Receiver() {};
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	public CountDownLatch getLatch() {
		return latch;
	}
	
	@KafkaListener(topics="mocks")
	public void receiveMocks(ConsumerRecord<?, ?> cr) {
//		Would be used if mocks were transfered as dto, but we need ALL the information here.
//		CourseMapper courseMapper = new CourseMapper();
//		List<Course> coursesToSimulate = courseMapper.courseDTOsToCourses((List<CourseDTO>) cr.value());
		System.out.println("Received mocks : " + cr.value().toString());
		List<Course> coursesToSimulate = (List<Course>) cr.value();
		Simulateur simulateur = new Simulateur(coursesToSimulate);
		GeoApplication.setSimulateur(simulateur);
		simulateur.startSimulation();
		latch.countDown();
	}
        
        @KafkaListener(topics="newCourse")
        public void receiveCourse(ConsumerRecord<?, ?> cr){
        	System.out.println("Received new course : " + cr.value().toString());
            Course course = (Course) cr.value();
            GeoApplication.getSimulateur().addCourse(course);
            new Thread(course).start();
        }
}
