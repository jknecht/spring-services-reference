package example.api.v1.controller;


import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import example.service.api.WeatherServiceException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ WeatherServiceException.class })
    protected ResponseEntity<Object> handleWeatherServiceException(WeatherServiceException e, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ApplicationExceptionMessage message = new ApplicationExceptionMessage();
        message.setMessage(e.getMessage());
        
        HashMap<String, String> additionalInfo = new HashMap<>();
        additionalInfo.put("zipCode", e.getZipCode());
        message.setAdditionalInformation(additionalInfo);
        
        return handleExceptionInternal(e, message, headers, HttpStatus.BAD_REQUEST, request);
    }

	
    @ExceptionHandler({ RuntimeException.class })
    protected ResponseEntity<Object> handleInvalidRequest(RuntimeException e, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ApplicationExceptionMessage message = new ApplicationExceptionMessage();
        message.setMessage(e.getMessage());
        
        return handleExceptionInternal(e, message, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}
