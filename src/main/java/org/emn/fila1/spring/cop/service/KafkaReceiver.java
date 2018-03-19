package org.emn.fila1.spring.cop.service;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.emn.fila1.spring.cop.model.Passage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaReceiver {
	
	public static KafkaReceiver receiver = new KafkaReceiver();
	
	private KafkaReceiver() {};
	
	@Autowired 
	private GeolocationService geoLocationService;
	
	private final CountDownLatch latch = new CountDownLatch(1);
	
	@KafkaListener(topics = "cop")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		Passage passage = (Passage) cr.value();
		geoLocationService.calculatePassage(passage);
		latch.countDown();
	}
}
