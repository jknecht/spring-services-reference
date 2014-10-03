package example.api.v1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.api.v1.domain.Greeting;


@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingController {

    @RequestMapping(value = "/{name}")
    public ResponseEntity<Greeting> getGreeting(@PathVariable("name") String name) {
        Greeting greeting = new Greeting();
        greeting.setMessage(String.format("Hello %s.", name));
        return ResponseEntity.ok(greeting);
    }
}
