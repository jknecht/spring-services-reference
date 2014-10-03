package example.api.domain;

import java.io.Serializable;

public class Greeting implements Serializable {

    private static final long serialVersionUID = 6760521539424044246L;
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
