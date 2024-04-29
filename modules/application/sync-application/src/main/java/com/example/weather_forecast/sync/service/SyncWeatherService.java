package com.example.weather_forecast.sync.service;

import com.example.weather_forecast.service.WeatherAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyncWeatherService {

    @Autowired
    private WeatherAPIService weatherAPIService;

    public void syncWeatherData(String baseUri, String regionCode, String apiKey) {
        weatherAPIService.fetchAndSaveWeatherData(baseUri, regionCode, apiKey);
    }
}
