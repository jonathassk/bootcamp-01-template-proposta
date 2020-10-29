package com.zupbootcamp.proposta.repositories;

import com.zupbootcamp.proposta.models.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    @Query(value = "SELECT * FROM PROPOSTA WHERE DOCUMENTO = :documento", nativeQuery = true)
    Optional<Proposta> findbyDocument(String documento);
}
