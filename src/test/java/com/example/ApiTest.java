package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class ApiTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String apiBaseUrl = System.getProperty("TEST_URL", "https://example.com");

    @Test
    public void testStatusApiReturnsOk() throws IOException {
        String endpoint = apiBaseUrl + "/api/status"; // Adjust as per actual API
        HttpURLConnection conn = (HttpURLConnection) new URL(endpoint).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        int responseCode = conn.getResponseCode();
        assertEquals("Expected HTTP 200 OK", 200, responseCode);

        InputStream responseStream = conn.getInputStream();
        JsonNode jsonResponse = objectMapper.readTree(responseStream);

        System.out.println("✅ JSON Response: " + jsonResponse.toString());
        assertEquals("ok", jsonResponse.get("status").asText());
    }

    @Test
    public void testVersionEndpoint() throws IOException {
        String endpoint = apiBaseUrl + "/api/version"; // Adjust as per actual API
        HttpURLConnection conn = (HttpURLConnection) new URL(endpoint).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        int responseCode = conn.getResponseCode();
        assertEquals("Expected HTTP 200 OK", 200, responseCode);

        JsonNode json = objectMapper.readTree(conn.getInputStream());
        assertEquals("1.0", json.get("version").asText()); // Expected version value
    }
}
