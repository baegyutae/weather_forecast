package com.example.weather_forecast.service;

import java.time.LocalDateTime;

public record WeatherDataResponse(
    LocalDateTime forecastTime,
    Double temperature,
    Integer humidity,
    String weatherCondition
) {

}
