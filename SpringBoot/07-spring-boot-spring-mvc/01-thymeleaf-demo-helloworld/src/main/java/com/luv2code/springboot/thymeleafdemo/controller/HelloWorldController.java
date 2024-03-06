package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // controller method to show initial HTML from
    @RequestMapping("/showForm")
    public String showForm(){
        return  "helloworld-form";
    }

    // controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }


    // controller method to read form data and add data to the model
    @RequestMapping("/processForm-v2")
    public String letsShout(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        //convert data to upper Case
        theName = theName.toUpperCase();

        // create message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
