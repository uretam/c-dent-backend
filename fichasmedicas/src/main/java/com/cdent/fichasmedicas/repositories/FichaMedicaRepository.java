package com.cdent.fichasmedicas.repositories;

import com.cdent.fichasmedicas.models.FichaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FichaMedicaRepository extends JpaRepository<FichaMedica, Long> {
    Optional<FichaMedica> findByIdPaciente(Long idPaciente);
}