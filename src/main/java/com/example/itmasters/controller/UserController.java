package com.example.itmasters.controller;

import com.example.itmasters.service.JobForUserService;
import com.example.itmasters.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;



}
