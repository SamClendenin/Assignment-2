package com.cs340.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@RestController
public class Controller {

    @GetMapping("/london")
    public Object getLondon() {
        try {
            String url = "http://api.weatherapi.com/v1/search.json?key=835b1dc21e1845b5af6170848241209&q=London\n";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            List<London> londonList = new ArrayList<>();

            for (JsonNode rt : root) {
                double id = rt.get("id").asDouble();
                String name = rt.get("name").asText();
                String region = rt.get("region").asText();
                String country = rt.get("country").asText();

                London london = new London(id, name, region, country);
                londonList.add(london);
            }
            return londonList;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /brew";
        }
    }
}
