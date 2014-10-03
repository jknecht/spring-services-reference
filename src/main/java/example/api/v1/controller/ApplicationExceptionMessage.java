package example.api.v1.controller;

public class ApplicationExceptionMessage {
    
    private String message;
    
    private Object additionalInformation;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Object additionalInformation) {
        this.additionalInformation = additionalInformation;
    }


}
