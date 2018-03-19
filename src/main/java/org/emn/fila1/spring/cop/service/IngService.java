package org.emn.fila1.spring.cop.service;

import org.emn.fila1.spring.cop.model.PassageCOP;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngService {

	@Autowired
	private KafkaSender kafkaSender;
	
    /**
     * Send JSONobject, to Kafka, that refers to the courseId, the calculated date and the state of the course.
     * @param passageCOP
     */
    public void postCourse(PassageCOP passageCOP) {
    	
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("courseId", passageCOP.getId());
        jsonObject.put("calculatedDate", passageCOP.getCalculatedDate());
        jsonObject.put("isCancelled", passageCOP.isCancelled());

        kafkaSender.send("ing", jsonObject);
    }

}
