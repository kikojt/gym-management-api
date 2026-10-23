package com.kikodev.gym_management_api.repository;

import com.kikodev.gym_management_api.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
