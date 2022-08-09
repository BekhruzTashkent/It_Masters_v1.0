package com.example.itmasters.repository;

import com.example.itmasters.entity.DirectionForUser;
import com.example.itmasters.entity.RankingForUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingForUserRepository extends JpaRepository<RankingForUser, Integer> {

}