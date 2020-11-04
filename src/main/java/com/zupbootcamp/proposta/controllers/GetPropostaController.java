package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import com.zupbootcamp.proposta.responses.PropostaResponse;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/propostas")
public class GetPropostaController {
    private final PropostaRepository propostaRepository;

    @Autowired
    public GetPropostaController (PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Optional<Proposta> getProposta (@PathVariable("id") String id) {
        return propostaRepository.findByPropostaId(id);
    }
}
