package com.example.itmasters.controller;

import com.example.itmasters.entity.DirectionForUser;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.DirectionForUserDTO;
import com.example.itmasters.service.DirectionForUserService;
import com.example.itmasters.service.JobForUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/directionForUser/")
@AllArgsConstructor
public class DirectionForUserController {

    private final JobForUserService jobForUserService;

    private final DirectionForUserService directionForUserService;


    @GetMapping
    public HttpEntity<?> getAllDirectionForUsers() {
        List<DirectionForUser> allDirectionForUser = directionForUserService.getAllDirectionForUser();
        return new ResponseEntity<>(allDirectionForUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getDirectionById(@PathVariable Integer id) {
        DirectionForUser directionForUser = directionForUserService.getById(id);
        return new ResponseEntity<>(directionForUser, HttpStatus.OK);
    }

    @PostMapping("/save")
    public HttpEntity<?> saveDirectionForUsers(@RequestBody DirectionForUserDTO directionForUserDTO) {
        ApiResponse addDirectionForUser = directionForUserService.addDirectionForUser(directionForUserDTO);
        return new ResponseEntity<>(addDirectionForUser.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @PutMapping("update")
    public HttpEntity<?> updateDirectionForUsers(@PathVariable Integer id, @RequestBody DirectionForUserDTO directionForUserDTO) {
        ApiResponse updateDirectionForUser = directionForUserService.updateDirectionForUser(id, directionForUserDTO);
        return new ResponseEntity<>(updateDirectionForUser.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteDirectionById(@PathVariable Integer id) {
        ApiResponse deleteDirectionForUser = directionForUserService.deleteDirectionForUser(id);
        return new ResponseEntity<>(deleteDirectionForUser.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

}
