package com.example.itmasters.controller;

import com.example.itmasters.entity.JobForUser;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.JobForUserDTO;
import com.example.itmasters.payload.UserDTO;
import com.example.itmasters.service.JobForUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jobForUser/")
@AllArgsConstructor
public class JobForUserController {

    private final JobForUserService jobForUserService;

    public HttpEntity<?> getAllJobForUser(){
        List<JobForUser> allJobs = jobForUserService.getAllJobs();
        return new ResponseEntity<>(allJobs, HttpStatus.OK);
    }

    public HttpEntity<?> getJobForUserById(@PathVariable Integer id){
        JobForUser jobForUserById = jobForUserService.getJobForUserById(id);
        return new ResponseEntity<>(jobForUserById, HttpStatus.OK);
    }

    public HttpEntity<?> addJobForUsers(@RequestBody JobForUserDTO jobForUserDTO){
        ApiResponse addJobForUser = jobForUserService.addJobForUser(jobForUserDTO);
        return new ResponseEntity<>(addJobForUser.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT);
    }

    public HttpEntity<?> updateJobForUsers(@PathVariable Integer id, @RequestBody JobForUserDTO jobForUserDTO){
        ApiResponse updateJobForUser = jobForUserService.updateJobForUser(id, jobForUserDTO);
        return new ResponseEntity<>(updateJobForUser.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    public HttpEntity<?> deleteJobForUsers(@PathVariable Integer id){
        ApiResponse deleteJobForUser = jobForUserService.deleteJobForUser(id);
        return new ResponseEntity<>(deleteJobForUser.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

}
