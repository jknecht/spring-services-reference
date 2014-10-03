package example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import example.generated.weather.WeatherReturn;
import example.generated.weather.WeatherSoap;
import example.service.api.CurrentWeather;
import example.service.api.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherSoap weatherSoapService;

    @Autowired
    ConversionService conversionService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * example.service.WeatherService#currentWeatherForZipCode(java.lang.String)
     */
    public CurrentWeather currentWeatherForZipCode(String zipCode) {
        WeatherReturn weatherReturn = weatherSoapService.getCityWeatherByZIP(zipCode);
        return conversionService.convert(weatherReturn, CurrentWeather.class);
    }

}
