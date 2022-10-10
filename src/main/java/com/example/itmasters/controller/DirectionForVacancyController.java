package com.example.itmasters.controller;

import com.example.itmasters.entity.DirectionForVacancy;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.DirectionForVacancyDTO;
import com.example.itmasters.service.DirectionForVacancyService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/directionForVacancy/")
@RequiredArgsConstructor
public class DirectionForVacancyController {

    private final DirectionForVacancyService directionForVacancyService;

    @GetMapping
    public HttpEntity<?> getAllDirectionForUsers() {
        List<DirectionForVacancy> all = directionForVacancyService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getDirectionById(@PathVariable Integer id) {
        Optional<DirectionForVacancy> byId = directionForVacancyService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/save")
    public HttpEntity<?> saveDirectionForUsers(@RequestBody DirectionForVacancyDTO directionForVacancyDTO) {
        ApiResponse apiResponse = directionForVacancyService.addDirectionForVacancy(directionForVacancyDTO);
        return new ResponseEntity<>(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @PutMapping("/update/{id}")
    public HttpEntity<?> updateDirectionForUsers(@PathVariable Integer id, @RequestBody DirectionForVacancyDTO directionForVacancyDTO) {
        ApiResponse apiResponse = directionForVacancyService.updateDirectionForVacancy(id, directionForVacancyDTO);
        return new ResponseEntity<>(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteDirectionById(@PathVariable Integer id) {
        ApiResponse apiResponse = directionForVacancyService.deleteById(id);
        return new ResponseEntity<>(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

}