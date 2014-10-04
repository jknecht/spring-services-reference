package example.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.convert.ConversionService;

import example.generated.weather.WeatherReturn;
import example.generated.weather.WeatherSoap;
import example.service.api.CurrentWeather;
import example.service.api.WeatherServiceException;

public class WeatherServiceImplTest {
	
	WeatherServiceImpl service;
	
	@Before
	public void setup() {
		service = new WeatherServiceImpl();
	}

	@Test
	public void serviceThrowsExceptionWhenResponseIsNotSuccessful() {
		String zipCode = "12345";
		String responseText = "The failure reason";
		
		WeatherSoap mockSoapService = Mockito.mock(WeatherSoap.class);
		WeatherReturn mockResponse = new WeatherReturn();
		mockResponse.setSuccess(false);
		mockResponse.setResponseText(responseText);
		
		Mockito.when(mockSoapService.getCityWeatherByZIP(Mockito.anyString())).thenReturn(mockResponse);
		service.weatherSoapService = mockSoapService;
		
		try {
			service.currentWeatherForZipCode(zipCode);
			Assert.fail("The weather service should have thrown an exception.");
		} catch(WeatherServiceException e) {
			Assert.assertEquals(responseText, e.getMessage());
			Assert.assertEquals(zipCode, e.getZipCode());
		}
	}
	
	@Test
	public void serviceReturnsWeatherWhenSuccessful() {
		String zipCode = "12345";
		
		WeatherSoap mockSoapService = Mockito.mock(WeatherSoap.class);
		WeatherReturn mockResponse = new WeatherReturn();
		mockResponse.setSuccess(true);
		Mockito.when(mockSoapService.getCityWeatherByZIP(Mockito.anyString())).thenReturn(mockResponse);

		ConversionService mockConversionService = Mockito.mock(ConversionService.class);
		CurrentWeather weather = new CurrentWeather();
		Mockito.when(mockConversionService.convert(mockResponse, CurrentWeather.class)).thenReturn(weather);
		service.weatherSoapService = mockSoapService;
		service.conversionService = mockConversionService;
		
		CurrentWeather serviceResponse = service.currentWeatherForZipCode(zipCode);
		Assert.assertEquals(weather, serviceResponse);
	}

}
