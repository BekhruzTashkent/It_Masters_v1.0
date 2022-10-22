package com.example.itmasters.entity;

import com.example.itmasters.entity.template.AbsIntegerIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class JobForVacancy extends AbsIntegerIDEntity {

    private String sphereType;

}
