package com.example.springbootassignment2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String landingPage() {
        System.out.println("Main Controller // " +
                "Now viewing index.html");
        return "index";
    }
}
