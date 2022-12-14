package com.example.itmasters.entity;

import com.example.itmasters.entity.template.AbsIntegerIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Attachment extends AbsIntegerIDEntity {

    private String fileOriginalName;

    private long size;

    private String contentType;

}
