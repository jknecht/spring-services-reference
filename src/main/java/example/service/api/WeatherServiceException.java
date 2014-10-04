package example.service.api;

public class WeatherServiceException extends RuntimeException {
	private String zipCode;
	
    public WeatherServiceException(String message, String zipCode) {
        super(message);
        this.zipCode = zipCode;
    }

	public String getZipCode() {
		return zipCode;
	}

}
