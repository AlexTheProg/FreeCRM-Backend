package com.example.freecrmbackend.exposition.user;

import com.example.freecrmbackend.application.service.user.UserService;
import com.example.freecrmbackend.domain.user.User;
import com.example.freecrmbackend.exposition.request.user.AddUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping("/test-endpoint")
    public String testEndpoint() {
        return "Test Endpoint with Auth";
    }


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody AddUserRequest request) {
        return ResponseEntity.ok(userService.addUser(request));
    }
}
