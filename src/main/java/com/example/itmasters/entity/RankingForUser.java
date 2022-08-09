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
public class RankingForUser extends AbsIntegerIDEntity {

   private Integer byRank;  //we change word byRank for future needs

   @ManyToOne
   private User user;

}
