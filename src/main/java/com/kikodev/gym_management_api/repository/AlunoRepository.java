package com.kikodev.gym_management_api.repository;

import com.kikodev.gym_management_api.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
