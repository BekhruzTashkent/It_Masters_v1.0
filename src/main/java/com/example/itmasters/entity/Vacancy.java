package com.example.itmasters.entity;

import com.example.itmasters.entity.template.AbsIntegerIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vacancy extends AbsIntegerIDEntity {

   private String companyName;

   private Integer password;

   private Integer prePassowrd;

   private String email;

   private String requirements;

   private String offers;

   private String rules;

   private String contact;

   private Integer salary;

   private String telegramUsername;

   private String typeForSpecialist;

   @ManyToOne
   private DirectionForVacancy directionForVacancy;

}
