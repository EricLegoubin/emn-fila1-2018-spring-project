package com.emn.GEO.kafka;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.emn.GEO.GeoApplication;
import com.emn.GEO.domain.Course;
import com.emn.GEO.service.dto.CourseDTO;
import com.emn.GEO.simulateur.Simulateur;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		CourseMapper courseMapper = new CourseMapper();
		List<Course> coursesToSimulate = courseMapper.courseDTOsToCourses((List<CourseDTO>) cr.value());
		GeoApplication.setSimulateur(new Simulateur(coursesToSimulate));
		latch.countDown();
	}
}
