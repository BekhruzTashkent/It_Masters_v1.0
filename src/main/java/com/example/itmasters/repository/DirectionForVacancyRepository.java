package com.example.itmasters.repository;


import com.example.itmasters.entity.DirectionForVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionForVacancyRepository extends JpaRepository<DirectionForVacancy, Integer> {

}
