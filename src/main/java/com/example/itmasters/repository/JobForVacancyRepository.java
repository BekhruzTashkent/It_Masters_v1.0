package com.example.itmasters.repository;

import com.example.itmasters.entity.JobForUser;
import com.example.itmasters.entity.JobForVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobForVacancyRepository extends JpaRepository<JobForVacancy, Integer> {

}
