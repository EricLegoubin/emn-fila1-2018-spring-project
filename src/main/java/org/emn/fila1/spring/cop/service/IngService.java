package org.emn.fila1.spring.cop.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.SLF4JLogFactory;
import org.emn.fila1.spring.cop.model.CourseCOP;
import org.emn.fila1.spring.cop.model.PassageCOP;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class IngService {

    private Log logger = SLF4JLogFactory.getLog(this.getClass());

    @Value("${infogare.url}")
    private String infoGareUrl;

    /**
     * Post JSONobject that refers to the courseId, the calculated date and the state of the course.
     * @param passageCOP
     */
    public void postCourse(PassageCOP passageCOP) {
        try {
            URL urlInfoGare = new URL(infoGareUrl);
            HttpURLConnection con = (HttpURLConnection) urlInfoGare.openConnection();
            con.setRequestMethod("POST");

            RestTemplate restTemplate = new RestTemplate();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("courseId", passageCOP.getId());
            jsonObject.put("calculatedDate", passageCOP.getCalculatedDate());
            jsonObject.put("isCancelled", passageCOP.isCancelled());

            restTemplate.postForObject(urlInfoGare.toString(), jsonObject, CourseCOP.class);

        } catch (MalformedURLException e) {
            logger.error("Malformed URL, found :" + infoGareUrl + "error message :" + e.getMessage());
        } catch (IOException io) {
            logger.error(io.getMessage());
        }

    }

}
