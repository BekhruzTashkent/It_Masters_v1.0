package com.example.itmasters.service;

import com.example.itmasters.entity.DirectionForUser;
import com.example.itmasters.entity.DirectionForVacancy;
import com.example.itmasters.entity.JobForUser;
import com.example.itmasters.entity.JobForVacancy;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.DirectionForUserDTO;
import com.example.itmasters.payload.DirectionForVacancyDTO;
import com.example.itmasters.repository.DirectionForUserRepository;
import com.example.itmasters.repository.DirectionForVacancyRepository;
import com.example.itmasters.repository.JobForUserRepository;
import com.example.itmasters.repository.JobForVacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DirectionForVacancyService {

   private final DirectionForVacancyRepository directionForVacancyRepository;

   private final JobForVacancyRepository jobForVacancyRepository;

   //in order to get all this get
   public List<DirectionForVacancy> getAll(){
       List<DirectionForVacancy> all = directionForVacancyRepository.findAll();
       return all;
   }

   public Optional<DirectionForVacancy> getById(Integer id){
       Optional<DirectionForVacancy> byId = directionForVacancyRepository.findById(id);
       return byId;
   }

   //it is for add directory for vacancy
   public ApiResponse addDirectionForVacancy(DirectionForVacancyDTO directionForVacancyDTO){

       Optional<JobForVacancy> byId = jobForVacancyRepository.findById(directionForVacancyDTO.getJobForVacancy_id());
       if(byId.isEmpty()){
           return new ApiResponse("no such job type", false);
       }

       DirectionForVacancy directionForVacancy = new DirectionForVacancy();
       directionForVacancy.setDirectionName(directionForVacancyDTO.getDirectionName());
       directionForVacancy.setJobForVacancy(byId.get());
       directionForVacancyRepository.save(directionForVacancy);

       return new ApiResponse("direction for vacancy added", true);
   }
    //this is for update direction
   public ApiResponse updateDirectionForVacancy(Integer id, DirectionForVacancyDTO directionForVacancyDTO){
       Optional<DirectionForVacancy> byId = directionForVacancyRepository.findById(id);
       if(byId.isEmpty()){
           return new ApiResponse("no such direction", false);
       }

       Optional<JobForVacancy> byIdJob = jobForVacancyRepository.findById(directionForVacancyDTO.getJobForVacancy_id());
       if(!byId.isPresent()){
           return new ApiResponse("no such job type", false);
       }


       DirectionForVacancy directionForVacancy = byId.get();
       directionForVacancy.setDirectionName(directionForVacancy.getDirectionName());
       directionForVacancy.setJobForVacancy(byIdJob.get());
       directionForVacancyRepository.save(directionForVacancy);
       return new ApiResponse("direction for new vacancy updated", true);
   }

   public ApiResponse deleteById(Integer id){
       directionForVacancyRepository.deleteById(id);
       return new ApiResponse("deleted", true);
   }

}
