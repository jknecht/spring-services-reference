package example.config;

import javax.xml.ws.BindingProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import example.generated.weather.Weather;
import example.generated.weather.WeatherSoap;

/**
 * Configuration for soap services that the application will need to communicate with.
 * 
 * @author jeff.knecht
 *
 */
@Configuration
public class SoapServiceConfig {
    
    @Bean
    WeatherSoap weatherSoapService() {
        Weather weatherService = new Weather();
        WeatherSoap port = weatherService.getWeatherSoap12();
        BindingProvider provider = (BindingProvider) port;
        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://wsf.cdyne.com/WeatherWS/Weather.asmx");
        return port;
    }

}
