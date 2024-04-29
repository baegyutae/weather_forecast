package com.example.weather_forecast.inquire.controller;

import com.example.weather_forecast.domain.WeatherForecast;
import com.example.weather_forecast.inquire.service.WeatherQueryService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherQueryController {

    @Autowired
    private WeatherQueryService weatherQueryService;

    @GetMapping("/weather")
    public ResponseEntity<List<WeatherForecast>> queryWeather(@RequestParam String region,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

        List<WeatherForecast> forecasts = weatherQueryService.findWeatherForecasts(region, start,
            end);
        if (forecasts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(forecasts, HttpStatus.OK);
    }
}
