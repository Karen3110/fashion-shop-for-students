package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.model.User;
import com.fshop.fashionshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    ResponseEntity<User> signUp(@RequestBody User user){
        return ResponseEntity.ok(userService.create(user));
    }


}
