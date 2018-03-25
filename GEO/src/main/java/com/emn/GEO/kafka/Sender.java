package com.emn.GEO.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	public static Sender sender = new Sender();
	
	private Sender() {};
	
	@Autowired
	private KafkaTemplate<String, String> template;
	
	public void send(String topic, String payload) {
		System.out.println("sending " + payload + " on " + topic);
		template.send(topic, payload);
	}
}
