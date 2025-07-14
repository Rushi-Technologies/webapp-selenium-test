package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

public class UrlTest {
    private WebDriver driver;
    private String testUrl;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        testUrl = System.getProperty("TEST_URL", "https://example.com");
    }

    @Test
    public void testPageTitleContainsExpectedText() {
        driver.get(testUrl);
        String title = driver.getTitle();
        System.out.println("✅ Page title is: " + title);
        assertTrue("Page title should contain 'Example Domain'", title.contains("Example Domain"));
    }

    @Test
    public void testHttpStatusIs200() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(testUrl).openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("✅ HTTP Response Code: " + responseCode);
        assertEquals("Expected HTTP 200 OK", 200, responseCode);
    }

    @Test
    public void testRestApiJsonField() throws IOException {
        String apiUrl = testUrl + "/api/status"; // Change based on your actual API endpoint
        HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        int responseCode = conn.getResponseCode();
        assertEquals("API should return 200", 200, responseCode);

        // You can parse JSON here using Jackson if needed
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
