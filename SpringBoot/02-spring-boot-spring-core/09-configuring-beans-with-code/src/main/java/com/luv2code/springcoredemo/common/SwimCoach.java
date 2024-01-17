package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach {


    // component annotation not used on purpose
    public SwimCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim faster, there's a shark in the water!";
    }
}
