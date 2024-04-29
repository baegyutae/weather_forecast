package com.example.weather_forecast.service;

import com.example.weather_forecast.domain.WeatherForecast;
import com.example.weather_forecast.repository.WeatherForecastRepository;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherAPIService {

    private final RestTemplate restTemplate;
    private final WeatherForecastRepository repository;

    @Autowired
    public WeatherAPIService(RestTemplate restTemplate, WeatherForecastRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    public void fetchAndSaveWeatherData(String baseUri, String regionCode, String apiKey) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUri)
            .queryParam("serviceKey", apiKey)
            .queryParam("nx", "경도값")
            .queryParam("ny", "위도값")
            .queryParam("base_date", "20210901")
            .queryParam("base_time", "0600")
            .queryParam("_type", "json")
            .build()
            .toUri();

        WeatherDataResponse response = restTemplate.getForObject(uri, WeatherDataResponse.class);
        if (response != null) {
            WeatherForecast forecast = convertToWeatherForecast(regionCode, response);
            repository.save(forecast);
        }
    }

    private WeatherForecast convertToWeatherForecast(String region, WeatherDataResponse response) {
        return new WeatherForecast(
            region,
            response.forecastTime(),
            response.temperature(),
            response.humidity(),
            response.weatherCondition()
        );
    }
}
