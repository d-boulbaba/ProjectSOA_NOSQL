package com.dailycodebuffer.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/bookServiceFallBack")
    public String userServiceFallBackMethod() {
        return "book Service is taking longer than Expected." +
                " Please try again later";
    }
    @GetMapping("/loanServiceFallBack")
    public String loanServiceFallBackMethod() {
        return "loan Service is taking longer than Expected." +
                " Please try again later";
    }
    @GetMapping("/studentServiceFallBack")
    public String studentServiceFallBackMethod() {
        return "student Service is taking longer than Expected." +
                " Please try again later";
    }
    @GetMapping("/adminServiceFallBack")
    public String adminServiceFallBackMethod() {
        return "admin Service is taking longer than Expected." +
                " Please try again later";
    }

}
