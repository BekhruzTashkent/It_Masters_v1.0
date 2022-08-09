package com.example.itmasters.controller;

import com.example.itmasters.entity.User;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.UserDTO;
import com.example.itmasters.service.JobForUserService;
import com.example.itmasters.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    public HttpEntity<?> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    public HttpEntity<?> getUserById(@PathVariable Integer id) {
        User userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    public HttpEntity<?> addUser(@RequestBody UserDTO userDTO) {
        ApiResponse addUser = userService.addUser(userDTO);
        return new ResponseEntity<>(addUser, HttpStatus.ACCEPTED);
    }

    public HttpEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        ApiResponse updateUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updateUser.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    public HttpEntity<?> deleteUserById(@PathVariable Integer id) {
        ApiResponse deleteUserByID = userService.deleteUserByID(id);
        return new ResponseEntity<>(deleteUserByID.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

}
