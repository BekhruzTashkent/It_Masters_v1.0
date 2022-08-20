package com.example.itmasters.repository;

import com.example.itmasters.entity.User;
import com.example.itmasters.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {

}
