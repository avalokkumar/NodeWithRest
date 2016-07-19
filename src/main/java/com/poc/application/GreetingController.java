package com.poc.application;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(method=RequestMethod.GET, headers = { "Accept=application/xml" }, produces="application/xml")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("Name is "+name);
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
