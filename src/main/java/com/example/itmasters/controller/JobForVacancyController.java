package com.example.itmasters.controller;

import com.example.itmasters.entity.JobForUser;
import com.example.itmasters.entity.JobForVacancy;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.JobForUserDTO;
import com.example.itmasters.payload.JobForVacancyDTO;
import com.example.itmasters.service.JobForUserService;
import com.example.itmasters.service.JobForVacancyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/jobForVacancy/")
@AllArgsConstructor
public class JobForVacancyController {

    private final JobForVacancyService jobForVacancyService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<JobForVacancy> all = jobForVacancyService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        Optional<JobForVacancy> vacancyById = jobForVacancyService.getVacancyById(id);
        return new ResponseEntity<>(vacancyById, HttpStatus.OK);
    }

    @PostMapping("/addJobType")
    public HttpEntity<?> addJob(@RequestBody JobForVacancyDTO jobForVacancyDTO){
        ApiResponse apiResponse = jobForVacancyService.addJobForVacancy(jobForVacancyDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/updateJobType")
    public HttpEntity<?> updateJob(@PathVariable Integer id, @RequestBody JobForVacancyDTO jobForVacancyDTO){
        ApiResponse apiResponse = jobForVacancyService.updateJobForVacancy(id, jobForVacancyDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteJob(@PathVariable Integer id){
        ApiResponse apiResponse = jobForVacancyService.deleteById(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
