package com.example.itmasters.repository;

import com.example.itmasters.entity.JobForUser;
import com.example.itmasters.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobForUserRepository extends JpaRepository<JobForUser, Integer> {

}
