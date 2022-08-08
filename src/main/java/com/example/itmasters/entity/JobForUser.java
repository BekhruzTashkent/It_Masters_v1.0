package com.example.itmasters.entity;

import javax.persistence.Entity;

import com.example.itmasters.entity.template.AbsIntegerIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class JobForUser extends AbsIntegerIDEntity {

    private String sphereType;

}
