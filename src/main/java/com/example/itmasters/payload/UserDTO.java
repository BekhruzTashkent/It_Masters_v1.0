package com.example.itmasters.payload;

import com.example.itmasters.entity.DirectionForUser;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDTO {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String prePassword;

    private Timestamp dateOfBirth;

    private String location;

    private String telephoneNumber;

    private String telegramAccount;

    private String email;

    private String portfolioLink;

    private String placeOfStudy;

    private Integer yearsOfExperience;

    private String skills;

    private String typeOfWork;

    private DirectionForUser directionForUser_id;

//    private Attachment attachment_id;

}
