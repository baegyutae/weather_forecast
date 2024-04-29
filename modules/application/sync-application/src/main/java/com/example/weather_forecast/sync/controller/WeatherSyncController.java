package com.example.weather_forecast.sync.controller;

import com.example.weather_forecast.sync.service.SyncWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherSyncController {

    @Autowired
    private SyncWeatherService syncWeatherService;

    @PostMapping("/weather/sync")
    public String syncWeatherData(@RequestParam String baseUri, @RequestParam String regionCode, @RequestParam String apiKey) {
        syncWeatherService.syncWeatherData(baseUri, regionCode, apiKey);
        return "Weather data synchronized successfully!";
    }
}