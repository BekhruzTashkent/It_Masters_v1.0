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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public HttpEntity<?> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getUserById(@PathVariable Integer id) {
        User userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PostMapping("/save")
    public HttpEntity<?> addUser(@RequestBody UserDTO userDTO) {
        ApiResponse addUser = userService.addUser(userDTO);
        return new ResponseEntity<>(addUser, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public HttpEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        ApiResponse updateUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updateUser.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteUserById(@PathVariable Integer id) {
        ApiResponse deleteUserByID = userService.deleteUserByID(id);
        return new ResponseEntity<>(deleteUserByID.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

}
