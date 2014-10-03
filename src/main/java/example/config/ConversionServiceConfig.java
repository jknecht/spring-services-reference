package example.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import example.api.v1.converter.CurrentWeatherToWeatherConverter;
import example.service.converter.WeatherSoapResponseConverter;

@Configuration
public class ConversionServiceConfig {

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
        factory.setConverters(getConverters());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
    
    @SuppressWarnings("rawtypes")
    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<Converter>();
        converters.add(new CurrentWeatherToWeatherConverter());
        converters.add(new WeatherSoapResponseConverter());
        return converters;
    }

}
