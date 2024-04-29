package com.example.weather_forecast.repository;


import com.example.weather_forecast.domain.WeatherForecast;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {

    List<WeatherForecast> findByRegionAndForecastTimeBetween(String region, LocalDateTime startTime,
        LocalDateTime endTime);
}

