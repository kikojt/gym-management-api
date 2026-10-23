package com.kikodev.gym_management_api.repository;

import com.kikodev.gym_management_api.domain.Assiduidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssiduidadeRepository extends JpaRepository<Assiduidade, Long> {
}
