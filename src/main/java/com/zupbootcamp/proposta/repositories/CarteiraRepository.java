package com.zupbootcamp.proposta.repositories;

import com.zupbootcamp.proposta.models.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, String> {
}
