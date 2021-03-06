package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.model.User;
import com.fshop.fashionshop.service.UserService;
import com.fshop.fashionshop.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 1. need to add checking for duplicated signups
 */


@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    ResponseEntity<User> signUp(@RequestBody User user) {

        /**
         *  1.
         */

        UserValidator.checkUserSignUp(user, HttpStatus.BAD_REQUEST, "user data is invalid to signUp");

        return ResponseEntity.ok(userService.create(user));
    }


}
