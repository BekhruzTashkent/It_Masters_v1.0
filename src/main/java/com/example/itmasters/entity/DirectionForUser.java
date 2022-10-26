package com.example.itmasters.entity;

import com.example.itmasters.entity.template.AbsIntegerIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class DirectionForUser extends AbsIntegerIDEntity {

    private String directionName;

    @ManyToOne
    private JobForUser jobForUser;

}
