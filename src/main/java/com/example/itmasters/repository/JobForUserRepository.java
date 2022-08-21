package com.example.itmasters.repository;

import com.example.itmasters.entity.JobForUser;
import com.example.itmasters.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobForUserRepository extends JpaRepository<JobForUser, Integer> {

}
