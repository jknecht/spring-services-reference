package example.service.converter;

import org.springframework.core.convert.converter.Converter;

import example.generated.weather.WeatherReturn;
import example.service.api.CurrentWeather;
import example.service.api.WeatherServiceException;

public class WeatherSoapResponseConverter implements Converter<WeatherReturn, CurrentWeather> {

    public CurrentWeather convert(WeatherReturn source) {
        CurrentWeather weather = new CurrentWeather();
        if (source.isSuccess()) {
            weather.setTemperature(source.getTemperature());
            weather.setCity(source.getCity());
            weather.setDescription(source.getDescription());
            weather.setPressure(source.getPressure());
            weather.setRelativeHumidity(source.getRelativeHumidity());
            weather.setRemarks(source.getRemarks());
            weather.setState(source.getState());
            weather.setVisibility(source.getVisibility());
            weather.setWeatherID(String.valueOf(source.getWeatherID()));
            weather.setWeatherStationCity(source.getWeatherStationCity());
            weather.setWind(source.getWind());
            weather.setWindchill(source.getWindChill());
        } else {
            throw new WeatherServiceException(source.getResponseText());
        }
        return weather;
    }
    
}
