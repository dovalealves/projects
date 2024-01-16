package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// component annotation marks the class as a Spring bean
@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void init(){
        System.out.println("Init(): " + getClass().getSimpleName());
    }

    //define destroy method
    @PreDestroy
    public void destroy(){
        System.out.println("destroy(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes xD";
    }
}
