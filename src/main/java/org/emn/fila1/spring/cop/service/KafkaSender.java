package org.emn.fila1.spring.cop.service;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, JSONObject> kafkaTemplate;
	
	public void send(String topic, JSONObject jsonObject) {
	    kafkaTemplate.send(topic, jsonObject);
	}
}
