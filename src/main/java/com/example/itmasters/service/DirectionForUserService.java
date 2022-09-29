package com.example.itmasters.service;

import com.example.itmasters.entity.DirectionForUser;
import com.example.itmasters.entity.JobForUser;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.DirectionForUserDTO;
import com.example.itmasters.repository.DirectionForUserRepository;
import com.example.itmasters.repository.JobForUserRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DirectionForUserService {

    private final DirectionForUserRepository directionForUserRepository;

    private final JobForUserRepository jobForUserRepository;

    public List<DirectionForUser> getAllDirectionForUser() {
        return directionForUserRepository.findAll();
    }

    public DirectionForUser getById(Integer id) {
        Optional<DirectionForUser> optionalDirectionForUser = directionForUserRepository.findById(id);
        return optionalDirectionForUser.orElse(null);
    }

    public ApiResponse addDirectionForUser(DirectionForUserDTO directionForUserDTO) {

        Optional<JobForUser> optionalJobForUser = jobForUserRepository.findById(directionForUserDTO.getJobForUser_id());

        DirectionForUser directionForUser = new DirectionForUser();
        directionForUser.setDirectionName(directionForUserDTO.getFieldName());
        //practise method, may be it doesn't work. I hope you will check it my dear best friend 😂😉😎
        optionalJobForUser.ifPresent(directionForUser::setJobForUser);
        directionForUserRepository.save(directionForUser);

        return new ApiResponse("DirectionForUser added successfully", true);

    }

    public ApiResponse updateDirectionForUser(Integer id, DirectionForUserDTO directionForUserDTO) {

        Optional<JobForUser> optionalJobForUser = jobForUserRepository.findById(directionForUserDTO.getJobForUser_id());

        Optional<DirectionForUser> optionalDirectionForUser = directionForUserRepository.findById(id);
        if (optionalDirectionForUser.isPresent()) {
            DirectionForUser directionForUser = optionalDirectionForUser.get();
            directionForUser.setDirectionName(directionForUserDTO.getFieldName());
            optionalJobForUser.ifPresent(directionForUser::setJobForUser);
            directionForUserRepository.save(directionForUser);
            return new ApiResponse("DirectionForUser is updated successfully", true);
        } else {
            return new ApiResponse("There is no directionForUser with this id", false);
        }
    }

    public ApiResponse deleteDirectionForUser(Integer id) {

        Optional<DirectionForUser> optionalDirectionForUser = directionForUserRepository.findById(id);

        if (optionalDirectionForUser.isPresent()) {
            directionForUserRepository.deleteById(id);
            return new ApiResponse("DirectionForUser is deleted successfully", true);
        } else {
            return new ApiResponse("There is no DirectionForUser with this id", false);
        }

    }

}