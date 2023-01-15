package com.example.freecrmbackend.exposition.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @GetMapping("/test-endpoint")
    public String testEndpoint() {
        return "Test Endpoint with Auth";
    }

    @PostMapping("/users")
    public void createUser(UserAuthRepresentation userAuthRepresentation){}
}
