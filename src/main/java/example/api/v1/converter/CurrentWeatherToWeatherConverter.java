package example.api.v1.converter;

import org.springframework.core.convert.converter.Converter;

import example.api.v1.domain.Weather;
import example.service.api.CurrentWeather;


/**
 * Converts a CurrentWeather object from the middle-tier weather service
 * to a Weather object for the JSON API.
 * 
 * @author jeff.knecht
 */
public class CurrentWeatherToWeatherConverter implements Converter<CurrentWeather, Weather>{

    public Weather convert(CurrentWeather source) {
        Weather weather = new Weather();
        weather.setTemperature(Integer.valueOf(source.getTemperature()));
        weather.setCity(source.getCity());
        weather.setDescription(source.getDescription());
        weather.setPressure(source.getPressure());
        weather.setRelativeHumidity(source.getRelativeHumidity());
        weather.setRemarks(source.getRemarks());
        weather.setState(source.getState());
        weather.setVisibility(source.getVisibility());
        weather.setWind(source.getWind());
        weather.setWindchill(source.getWindchill());
        return weather;
    }

}
