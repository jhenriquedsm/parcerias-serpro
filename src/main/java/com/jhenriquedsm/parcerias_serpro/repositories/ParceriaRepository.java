package com.jhenriquedsm.parcerias_serpro.repositories;

import com.jhenriquedsm.parcerias_serpro.model.Parceria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParceriaRepository extends JpaRepository<Parceria, Long> {
    boolean existsByTitle(String title);
}