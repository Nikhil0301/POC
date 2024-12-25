package com.lms.librarymanagement.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lms.librarymanagement.dto.UserProxy;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    // Example of making a GET request to an external API
    public String getApiResponse() {
        String url = "http://localhost:9090/api/endpoint"; // Replace with your API URL

        // Call the API using RestTemplate
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        // Get the response body as a string
        String responseBody = response.getBody();
        return responseBody;
    }
    
    public UserProxy getUserById(Long userId) {
        String url = "http://localhost:7080/api/users/{id}"; // External API URL

        // Create a map to pass the user ID as a path variable
        Map<String, Long> params = new HashMap();
        params.put("id", userId);

        // Make the GET request and return the response as a User object
        return restTemplate.getForObject(url, UserProxy.class, params);
    }
}
