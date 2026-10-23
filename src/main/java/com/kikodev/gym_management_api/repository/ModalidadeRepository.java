package com.kikodev.gym_management_api.repository;

import com.kikodev.gym_management_api.domain.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {
}
