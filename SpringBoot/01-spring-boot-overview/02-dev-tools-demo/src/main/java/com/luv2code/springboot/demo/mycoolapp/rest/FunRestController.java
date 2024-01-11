package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //expose "/" endpoint that will return "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // expose a new endpoints to try devtools

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String fortuneTeller(){
        return "You won the lottery!";
    }
}
