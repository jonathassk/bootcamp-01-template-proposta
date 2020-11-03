package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.feing.AnaliseClient;
import com.zupbootcamp.proposta.feing.requests.AnaliseRequest;
import com.zupbootcamp.proposta.feing.responses.AnaliseResponse;
import com.zupbootcamp.proposta.feing.responses.ResultadoSolicitacao;
import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import com.zupbootcamp.proposta.requests.PropostaRequest;
import com.zupbootcamp.proposta.services.PropostaService;
import com.zupbootcamp.proposta.shared.VerificarDocumento;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/propostas")
public class CreatePropostaController {

    private final PropostaService propostaService;
    private final VerificarDocumento verificarDocumento;

    @Autowired
    public CreatePropostaController (PropostaService propostaService, VerificarDocumento verificarDocumento) {
        this.propostaService = propostaService;
        this.verificarDocumento = verificarDocumento;
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createProposta (@Valid @RequestBody PropostaRequest req, UriComponentsBuilder builder) {
        verificarDocumento.verificarTamanhoCoexistencia(req);
        Proposta proposta = req.toModel();
        propostaService.criarProposta(proposta);
        return ResponseEntity.created(builder.path("/api/v1/propostas/{id}").buildAndExpand(proposta.getId()).toUri()).build();
    }
}
