package com.example.itmasters.service;

import com.example.itmasters.entity.JobForVacancy;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.JobForVacancyDTO;
import com.example.itmasters.repository.JobForVacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
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
        return new ApiResponse("New job vacancy successfully added", true);
    }

    public ApiResponse updateJobForVacancy(Integer id, JobForVacancyDTO jobForVacancyDTO){
        Optional<JobForVacancy> byId = jobForVacancyRepository.findById(id);
        if(byId.isPresent()){
            return new ApiResponse("Unfortunately, nope such kind of job type", false);
        }

        JobForVacancy jobForVacancy = byId.get();
        jobForVacancy.setSphereType(jobForVacancyDTO.getSphereType());
        jobForVacancyRepository.save(jobForVacancy);
        return new ApiResponse("Job For Vacancy updated successfully", true);

    }

    public ApiResponse deleteById(Integer id){
        jobForVacancyRepository.deleteById(id);
        return new ApiResponse("Job For Vacancy deleted successfully", true);
    }

}
