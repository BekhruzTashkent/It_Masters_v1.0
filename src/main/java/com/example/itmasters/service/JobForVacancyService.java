package com.example.itmasters.service;

import com.example.itmasters.entity.JobForUser;
import com.example.itmasters.entity.JobForVacancy;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.JobForUserDTO;
import com.example.itmasters.payload.JobForVacancyDTO;
import com.example.itmasters.repository.JobForUserRepository;
import com.example.itmasters.repository.JobForVacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobForVacancyService {

    private final JobForVacancyRepository jobForVacancyRepository;

    public List<JobForVacancy> getAll(){
        List<JobForVacancy> all = jobForVacancyRepository.findAll();
        return all;
    }

    public Optional<JobForVacancy> getVacancyById(Integer id){

        Optional<JobForVacancy> byId = jobForVacancyRepository.findById(id);
        return byId;

    }

    public ApiResponse addJobForVacancy(JobForVacancyDTO jobForVacancyDTO){

        JobForVacancy jobForVacancy = new JobForVacancy();
        jobForVacancy.setSphereType(jobForVacancyDTO.getSphereType());
        jobForVacancyRepository.save(jobForVacancy);
        return new ApiResponse("added", true);
    }

    public ApiResponse updateJobForVacancy(Integer id, JobForVacancyDTO jobForVacancyDTO){
        Optional<JobForVacancy> byId = jobForVacancyRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such job type", false);
        }

        JobForVacancy jobForVacancy = byId.get();
        jobForVacancy.setSphereType(jobForVacancyDTO.getSphereType());
        jobForVacancyRepository.save(jobForVacancy);
        return new ApiResponse("updated", true);

    }

    public ApiResponse deleteById(Integer id){
        jobForVacancyRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }

}