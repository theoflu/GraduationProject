package com.theoflu.ChatService.controller;

import com.theoflu.ChatService.error.ResultMessage;
import com.theoflu.ChatService.model.User;
import com.theoflu.ChatService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;


@CrossOrigin(origins = "*", maxAge = 3600,allowedHeaders = "*")

@RestController

@RequestMapping("/api")
@RequiredArgsConstructor

public class UserController {

    private  final UserService userService;
    @GetMapping("/username")
    public ResultMessage getUsername(@RequestHeader(value = "Authorization", required = false) String token) {
       return userService.returnUsername(token);
    }
}
