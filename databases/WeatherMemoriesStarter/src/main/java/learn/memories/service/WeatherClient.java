package learn.memories.service;

import java.time.LocalDate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * WeatherClient demonstrates how to use Spring's RestTemplate to consume the Open-Meteo Archive API.
 * * NOTE: To run this code, you must have the following dependencies in your project:
 * - spring-boot-starter-web (for RestTemplate)
 * - jackson-databind (for JSON processing)
 */
public class WeatherClient {

    private final RestTemplate restTemplate;

    private static final String API_BASE_URL = "https://archive-api.open-meteo.com/v1/archive";



    public WeatherClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getHourlyTemperature(double latitude,
                                                double longitude,
                                                LocalDate startDate,
                                                LocalDate endDate) {

        String url = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("startDate", startDate.toString())
                .queryParam("endDate", endDate.toString())
                .queryParam("hourly", "temperature_2m")
                .toUriString();
        System.out.println("Fetching Data from URL: " + url);

        try {
            WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
            return weatherResponse;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}