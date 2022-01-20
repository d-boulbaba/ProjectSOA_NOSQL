package com.dailycodebuffer.cloud.gateway;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
public class FallBackMethodController {
    @CrossOrigin(origins = "*")
    @GetMapping("/bookServiceFallBack")
    public String userServiceFallBackMethod() {
        return "book Service is taking longer than Expected." +
                " Please try again later";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/loanServiceFallBack")
    public String loanServiceFallBackMethod() {
        return "loan Service is taking longer than Expected." +
                " Please try again later";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/studentServiceFallBack")
    public String studentServiceFallBackMethod() {
        return "student Service is taking longer than Expected." +
                " Please try again later";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/adminServiceFallBack")
    public String adminServiceFallBackMethod() {
        return "admin Service is taking longer than Expected." +
                " Please try again later";
    }

}
