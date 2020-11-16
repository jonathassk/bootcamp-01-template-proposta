package com.zupbootcamp.proposta.repositories;

import com.zupbootcamp.proposta.models.AvisoViagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagemRepository extends JpaRepository<AvisoViagem, String> {
}
