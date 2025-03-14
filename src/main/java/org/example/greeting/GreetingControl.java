package org.example.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingControl {
    private static final String template = "Hello, %s! You are %d years old.";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World", required = true) String name,
                             @RequestParam(value="age", defaultValue = "18") int age) {
        System.out.print("RequestParam:" + String.format(template, name, age));
        return new Greeting(counter.incrementAndGet(), String.format(template, name, age));
    }
}
