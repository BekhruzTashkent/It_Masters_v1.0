package com.example.itmasters.service;

import com.example.itmasters.entity.Attachment;
import com.example.itmasters.entity.DirectionForUser;
import com.example.itmasters.entity.RankingForUser;
import com.example.itmasters.entity.User;
import com.example.itmasters.payload.ApiResponse;
import com.example.itmasters.payload.UserDTO;
import com.example.itmasters.repository.AttachmentRepository;
import com.example.itmasters.repository.DirectionForUserRepository;
import com.example.itmasters.repository.RankingForUserRepository;
import com.example.itmasters.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AttachmentRepository attachmentRepository;

    private final RankingForUserRepository rankingForUserRepository;

    private final DirectionForUserRepository directionForUserRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public ApiResponse addUser(UserDTO userDTO){

        Optional<DirectionForUser> optionalDirectionForUser = directionForUserRepository.findById(userDTO.getDirectionForUser_id());

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(userDTO.getAttachment_id());

        Optional<RankingForUser> optionalRankingForUser = rankingForUserRepository.findById(userDTO.getRanking_id());

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPrePassword(userDTO.getPrePassword());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setLocation(userDTO.getLocation());
        user.setTelephoneNumber(userDTO.getTelephoneNumber());
        user.setTelegramAccount(userDTO.getTelegramAccount());
        user.setPortfolioLink(userDTO.getPortfolioLink());
        user.setPlaceOfStudy(userDTO.getPlaceOfStudy());
        user.setYearsOfExperience(userDTO.getYearsOfExperience());
        user.setSkills(userDTO.getSkills());
        user.setTypeOfWork(userDTO.getTypeOfWork());
        optionalDirectionForUser.ifPresent(user::setDirectionForUser);
        optionalAttachment.ifPresent(user::setAttachment);
        optionalRankingForUser.ifPresent(user::setRankingForUser);
        userRepository.save(user);
        return new ApiResponse("User added successfully", true);
    }

    public ApiResponse updateUser(Integer id, UserDTO userDTO){

        Optional<DirectionForUser> optionalDirectionForUser = directionForUserRepository.findById(userDTO.getDirectionForUser_id());

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(userDTO.getAttachment_id());

        Optional<RankingForUser> optionalRankingForUser = rankingForUserRepository.findById(userDTO.getRanking_id());

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setPrePassword(userDTO.getPrePassword());
            user.setDateOfBirth(userDTO.getDateOfBirth());
            user.setLocation(userDTO.getLocation());
            user.setTelephoneNumber(userDTO.getTelephoneNumber());
            user.setTelegramAccount(userDTO.getTelegramAccount());
            user.setPortfolioLink(userDTO.getPortfolioLink());
            user.setPlaceOfStudy(userDTO.getPlaceOfStudy());
            user.setYearsOfExperience(userDTO.getYearsOfExperience());
            user.setSkills(userDTO.getSkills());
            user.setTypeOfWork(userDTO.getTypeOfWork());
            optionalDirectionForUser.ifPresent(user::setDirectionForUser);
            optionalAttachment.ifPresent(user::setAttachment);
            optionalRankingForUser.ifPresent(user::setRankingForUser);
            userRepository.save(user);
            return new ApiResponse("User updated successfully", true);
        } else {
            return new ApiResponse("There is no user with this id", false);
        }

    }

    public ApiResponse deleteUserByID(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return new ApiResponse("User deleted successfully", true);
        } else {
            return new ApiResponse("There is no user with this id", false);
        }
    }

}
