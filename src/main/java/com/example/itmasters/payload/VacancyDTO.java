package com.example.itmasters.payload;

import com.example.itmasters.entity.DirectionForVacancy;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class VacancyDTO {

    private String companyName;

    private Integer password;

    private Integer prePassword;

    private String email;

    private String requirements;

    private String offers;

    private String rules;

    private String contact;

    private Integer salary;

    private String telegramUsername;

    private String typeForSpecialist;

    private Integer directionForVacancy_id;

}