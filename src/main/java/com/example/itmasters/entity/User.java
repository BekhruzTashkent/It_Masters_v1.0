package com.example.itmasters.entity;

import com.example.itmasters.entity.template.AbsIntegerIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity(name = "users")
public class User extends AbsIntegerIDEntity {

    private String firstName;

    private String lastName;

    private String password;

    private String prePassword;

    private String username;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd HH:mm")
    @Column(name = "dateOfBirth")
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



}
