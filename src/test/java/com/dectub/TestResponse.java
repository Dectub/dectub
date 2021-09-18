package com.dectub;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TestResponse {
    private final ResponseEntity<String> response;

    public TestResponse(ResponseEntity<String> response) {
        this.response = response;
    }

    public HttpStatus statusCode() {
        return response.getStatusCode();
    }

    public <T> T value(String jsonPath) {
        return JsonPath.compile(jsonPath).read(response.getBody());
    }

    public Object[] jsonValues(String jsonPath) {
        return JsonPath.compile(jsonPath).<JSONArray>read(response.getBody()).toArray();
    }

    public String textBody() {
        return response.getBody();
    }

    public List<String> header(String header) {
        return response.getHeaders().get(header);
    }
}
