package com.emn.GEO.kafka;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);
	
	public CountDownLatch getLatch() {
		return latch;
	}
	
	@KafkaListener(topics="mocks")
	public void receive(ConsumerRecord<?, ?> cr) {
		System.out.println(cr.toString());
		latch.countDown();
	}
}
