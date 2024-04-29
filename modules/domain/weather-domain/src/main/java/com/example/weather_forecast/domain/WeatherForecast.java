package com.example.weather_forecast.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weather_forecasts")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private LocalDateTime forecastTime;

    @Column(nullable = true)
    private Double temperature;

    @Column(nullable = true)
    private Integer humidity;

    @Column(nullable = false)
    private String weatherCondition;

    @Builder
    public WeatherForecast(String region, LocalDateTime forecastTime, Double temperature,
        Integer humidity, String weatherCondition) {
        this.region = region;
        this.forecastTime = forecastTime;
        this.temperature = temperature;
        this.humidity = humidity;
        this.weatherCondition = weatherCondition;
    }
}
