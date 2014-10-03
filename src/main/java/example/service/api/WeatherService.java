package example.service.api;


public interface WeatherService {

    /**
     * Returns the current weather conditions for the supplied zip code.
     * 
     * @param zipCode
     * @return
     */
    CurrentWeather currentWeatherForZipCode(String zipCode);

}