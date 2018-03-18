package org.emn.fila1.spring.cop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class IngController {


    @Value("${infogare.url}")
    private String infoGareUrl;

    public void sendCourseModification()
    {
        try {
            URL urlInfoGare = new URL(infoGareUrl);
            HttpURLConnection con = (HttpURLConnection) urlInfoGare.openConnection();
            con.setRequestMethod("POST");

            RestTemplate restTemplate = new RestTemplate();


        } catch (MalformedURLException e)
        {
            System.out.println("Malformed URL, found :"+ infoGareUrl +"error message :"+ e.getMessage());
        } catch(IOException io) {
            System.out.println(io.getMessage());
        }



    }

	
}
