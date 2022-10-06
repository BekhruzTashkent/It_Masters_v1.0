package com.example.itmasters.service;

import com.example.itmasters.entity.*;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.UserDTO;
import com.example.itmasters.payload.VacancyDTO;
import com.example.itmasters.repository.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final DirectionForVacancyRepository directionForVacancyRepository;

    private final JobForVacancyRepository jobForVacancyRepository;

    private final VacancyRepository vacancyRepository;

    public List<Vacancy> getAll() {
        List<Vacancy> all = vacancyRepository.findAll();
        return all;
    }

    public Optional<Vacancy> getById(Integer id) {
        Optional<Vacancy> byId = vacancyRepository.findById(id);
        return byId;
    }

    public ApiResponse addVacancy(VacancyDTO vacancyDTO) {

        Optional<DirectionForVacancy> byId = directionForVacancyRepository.findById(vacancyDTO.getDirectionForVacancy_id());
        if (byId.isEmpty()) {
            return new ApiResponse("no such direction", false);
        }

        Vacancy vacancy = new Vacancy();
        vacancy.setCompanyName(vacancyDTO.getCompanyName());
        vacancy.setPassword(vacancyDTO.getPassword());
        vacancy.setPrePassword(vacancy.getPrePassword());
        vacancy.setEmail(vacancyDTO.getEmail());
        vacancy.setRequirements(vacancyDTO.getRequirements());
        vacancy.setOffers(vacancyDTO.getOffers());
        vacancy.setRules(vacancyDTO.getRules());
        vacancy.setContact(vacancyDTO.getContact());
        vacancy.setSalary(vacancyDTO.getSalary());
        vacancy.setTelegramUsername(vacancyDTO.getTelegramUsername());
        vacancy.setTypeForSpecialist(vacancyDTO.getTypeForSpecialist());
        vacancy.setDirectionForVacancy(byId.get());
        vacancyRepository.save(vacancy);
        return new ApiResponse("added", true);
    }

    public ApiResponse updateVacancy(Integer id, VacancyDTO vacancyDTO) {
        Optional<DirectionForVacancy> byId = directionForVacancyRepository.findById(vacancyDTO.getDirectionForVacancy_id());
        if (byId.isEmpty()) {
            return new ApiResponse("no such direction", false);
        }

        Optional<Vacancy> vacancyRepositoryById = vacancyRepository.findById(id);
        if (vacancyRepositoryById.isEmpty()) {
            return new ApiResponse("no such vacancy with this id", false);
        }

        Vacancy vacancy = vacancyRepositoryById.get();
        vacancy.setCompanyName(vacancyDTO.getCompanyName());
        vacancy.setPassword(vacancyDTO.getPassword());
        vacancy.setPrePassword(vacancy.getPrePassword());
        vacancy.setEmail(vacancyDTO.getEmail());
        vacancy.setRequirements(vacancyDTO.getRequirements());
        vacancy.setOffers(vacancyDTO.getOffers());
        vacancy.setRules(vacancyDTO.getRules());
        vacancy.setContact(vacancyDTO.getContact());
        vacancy.setSalary(vacancyDTO.getSalary());
        vacancy.setTelegramUsername(vacancyDTO.getTelegramUsername());
        vacancy.setTypeForSpecialist(vacancyDTO.getTypeForSpecialist());
        vacancy.setDirectionForVacancy(byId.get());
        vacancyRepository.save(vacancy);
        return new ApiResponse("added", true);

    }

    public ApiResponse deleteById(Integer id) {
        Optional<Vacancy> byId = vacancyRepository.findById(id);
        if (byId.isEmpty()) {
            return new ApiResponse("There are no such vacancy", false);
        }

        vacancyRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }

}