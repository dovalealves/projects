package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Custom properties injection: coach.name and team.name

   @Value("${coach.name}")
    private String coachName;
   @Value("${team.name}")
    private String teamName;

   //expose new endpoint for "team info?

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: "+ coachName + ", Team name: " + teamName;
    }


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
