package com.example.itmasters.controller;

import com.example.itmasters.entity.User;
import com.example.itmasters.entity.Vacancy;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.UserDTO;
import com.example.itmasters.payload.VacancyDTO;
import com.example.itmasters.service.UserService;
import com.example.itmasters.service.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/vacancy/")
@AllArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @GetMapping
    public HttpEntity<?> getAllUsers() {
        List<Vacancy> all = vacancyService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getUserById(@PathVariable Integer id) {
        Optional<Vacancy> byId = vacancyService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("/save")
    public HttpEntity<?> addUser(@RequestBody VacancyDTO vacancyDTO) {
        ApiResponse apiResponse = vacancyService.addVacancy(vacancyDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public HttpEntity<?> updateUser(@PathVariable Integer id, @RequestBody VacancyDTO vacancyDTO ){
        ApiResponse apiResponse = vacancyService.updateVacancy(id, vacancyDTO);
        return new ResponseEntity<>(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteUserById(@PathVariable Integer id) {
        ApiResponse apiResponse = vacancyService.deleteById(id);
        return new ResponseEntity<>(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

}
