package example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @RequestMapping(value = "/{name}")
    public ResponseEntity<Greeting> getGreeting(@PathVariable("name") String name) {
        Greeting greeting = new Greeting();
        greeting.setMessage(String.format("Hello %s.", name));
        return ResponseEntity.ok(greeting);
    }
}
