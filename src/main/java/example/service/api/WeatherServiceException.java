package example.service.api;

public class WeatherServiceException extends RuntimeException {

    public WeatherServiceException() {
        // TODO Auto-generated constructor stub
    }

    public WeatherServiceException(String message) {
        super(message);
    }

    public WeatherServiceException(Throwable cause) {
        super(cause);
    }

    public WeatherServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
