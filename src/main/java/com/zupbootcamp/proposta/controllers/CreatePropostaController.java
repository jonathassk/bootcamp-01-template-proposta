package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import com.zupbootcamp.proposta.requests.PropostaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/propostas")
public class CreatePropostaController {

    private final PropostaRepository propostaRepository;

    @Autowired
    public CreatePropostaController (PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createProposta (@Valid @RequestBody PropostaRequest req, UriComponentsBuilder builder) {
        Proposta proposta = req.toModel();
        Optional<Proposta> propostaOptional = propostaRepository.findbyDocument(req.getDocumento());
        if (propostaOptional.isPresent()) {
            return ResponseEntity.status(422).body("Proposta com o documento "+ req.getDocumento() +" já existe");
        }
        propostaRepository.save(proposta);
        return ResponseEntity.created(builder.path("/api/v1/propostas/{id}").buildAndExpand(proposta.getId()).toUri()).build();
    }
}
