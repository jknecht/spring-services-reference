package example.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import example.generated.weather.WeatherReturn;
import example.generated.weather.WeatherSoap;
import example.service.api.CurrentWeather;
import example.service.api.WeatherService;
import example.service.api.WeatherServiceException;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	public static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

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
    public CurrentWeather currentWeatherForZipCode(String zipCode) throws WeatherServiceException {
    	log.trace("Looking up weather for zip code: {}", zipCode);
        WeatherReturn weatherReturn = weatherSoapService.getCityWeatherByZIP(zipCode);
        if (!weatherReturn.isSuccess()) {
        	throw new WeatherServiceException(weatherReturn.getResponseText(), zipCode);
        }
        return conversionService.convert(weatherReturn, CurrentWeather.class);
    }

}
