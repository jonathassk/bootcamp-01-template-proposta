package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import com.zupbootcamp.proposta.requests.BiometriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Base64;

@RestController
@RequestMapping("/api/v1/biometria")
public class CreateBiometriaController {
    private final PropostaRepository propostaRepository;
    Base64.Decoder decoder = Base64.getDecoder();

    @Autowired
    public CreateBiometriaController(PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

    @PostMapping("/{idProposta}")
    public ResponseEntity<String> adicionarBiometria (@PathVariable("idProposta") String idProposta, @Valid @RequestBody BiometriaRequest biometriaRequest, UriComponentsBuilder builder) {
        Proposta proposta = propostaRepository.findByPropostaId(idProposta);
        if (proposta == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proposta não encontrada");
        }
        try {
            decoder.decode(biometriaRequest.getBiometria());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "biometria invalida");
        }
        proposta.setBiometria(biometriaRequest.getBiometria());
        propostaRepository.save(proposta);
        return ResponseEntity.created(builder.path("/api/v1/proposta/{idBiometria}").buildAndExpand(idProposta).toUri()).build();
    }
}
