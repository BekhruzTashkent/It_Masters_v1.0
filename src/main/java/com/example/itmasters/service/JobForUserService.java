package com.example.itmasters.service;

import com.example.itmasters.entity.JobForUser;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.JobForUserDTO;
import com.example.itmasters.repository.JobForUserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobForUserService {

    private final JobForUserRepository jobForUserRepository;

    public List<JobForUser> getAllJobs() {
        return jobForUserRepository.findAll();
    }

    public JobForUser getJobForUserById(Integer id) {
        Optional<JobForUser> optionalJobForUser = jobForUserRepository.findById(id);
        return optionalJobForUser.orElse(null);
    }



    public ApiResponse addJobForUser(JobForUserDTO jobForUserDTO) {

        JobForUser jobForUser = new JobForUser();
        jobForUser.setSphereType(jobForUserDTO.getSphereType());
        jobForUserRepository.save(jobForUser);

        return new ApiResponse("JobForUser is added successfully", true);
    }

    public ApiResponse updateJobForUser(Integer id, JobForUserDTO jobForUserDTO) {

        Optional<JobForUser> optionalJobForUser = jobForUserRepository.findById(id);

        if (optionalJobForUser.isPresent()) {
            JobForUser jobForUser = optionalJobForUser.get();
            jobForUser.setSphereType(jobForUserDTO.getSphereType());
            jobForUserRepository.save(jobForUser);
            return new ApiResponse("Updated successfully", true);
        } else {
            return new ApiResponse("There is no jobForUser with this id", false);
        }
    }

    public ApiResponse deleteJobForUser(Integer id){

        Optional<JobForUser> optionalJobForUser = jobForUserRepository.findById(id);
        if (optionalJobForUser.isPresent()) {
            jobForUserRepository.deleteById(id);
            return new ApiResponse("JobForUser deleted successfully", true);
        } else {
            return new ApiResponse("There is no JobForUser with this id", false);
        }

    }

}