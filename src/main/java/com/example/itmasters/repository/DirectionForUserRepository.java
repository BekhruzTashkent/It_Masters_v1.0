package com.example.itmasters.repository;

import com.example.itmasters.entity.DirectionForUser;
import com.example.itmasters.entity.JobForUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionForUserRepository extends JpaRepository<DirectionForUser, Integer> {

}
