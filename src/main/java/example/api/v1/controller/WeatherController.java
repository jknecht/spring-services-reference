package example.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.api.v1.domain.Weather;
import example.service.api.CurrentWeather;
import example.service.api.WeatherService;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;
    
    @Autowired
    ConversionService conversionService;
    
    @RequestMapping(value = "/{zipCode}", method = RequestMethod.GET)
    public ResponseEntity<Weather> weatherForZipcode(@PathVariable("zipCode") String zipCode) {
        CurrentWeather currentWeather = weatherService.currentWeatherForZipCode(zipCode);
        Weather weather = conversionService.convert(currentWeather, Weather.class);
        return ResponseEntity.ok(weather);
    }
}
