package example.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GreetingControllerTest {

    GreetingController controller;

    @Before
    public void setup() {
        controller = new GreetingController();
    }

    @Test
    public void greetingIncludesTheSuppliedName() {
        String name = "World";
        ResponseEntity<Greeting> response = controller.getGreeting(name);
        assertTrue("Response code was not OK", response.getStatusCode() == HttpStatus.OK);
        assertTrue("Greeting message did not contain the supplied name", response.getBody().getMessage().contains(name));
    }
}
