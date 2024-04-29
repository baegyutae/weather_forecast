package com.example.weather_forecast.inquire.service;

import com.example.weather_forecast.domain.WeatherForecast;
import com.example.weather_forecast.repository.WeatherForecastRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherQueryService {

    @Autowired
    private WeatherForecastRepository weatherForecastRepository;

    public List<WeatherForecast> findWeatherForecasts(String region, LocalDateTime start, LocalDateTime end) {
        return weatherForecastRepository.findByRegionAndForecastTimeBetween(region, start, end);
    }
}
