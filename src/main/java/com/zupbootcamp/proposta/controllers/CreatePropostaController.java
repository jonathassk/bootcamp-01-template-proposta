package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.feing.AnaliseClient;
import com.zupbootcamp.proposta.feing.requests.AnaliseRequest;
import com.zupbootcamp.proposta.feing.responses.AnaliseResponse;
import com.zupbootcamp.proposta.feing.responses.ResultadoSolicitacao;
import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import com.zupbootcamp.proposta.requests.PropostaRequest;
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

    private final PropostaRepository propostaRepository;
    private final AnaliseClient analiseClient;

    @Autowired
    public CreatePropostaController (PropostaRepository propostaRepository, AnaliseClient analiseClient) {
        this.propostaRepository = propostaRepository;
        this.analiseClient = analiseClient;
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createProposta (@Valid @RequestBody PropostaRequest req, UriComponentsBuilder builder) {
        Proposta proposta = req.toModel();
        Optional<Proposta> propostaOptional = propostaRepository.findbyDocument(req.getDocumento());
        if (propostaOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento já cadastrado");
        }
        try {
            AnaliseRequest analiseRequest = new AnaliseRequest(proposta.getDocumento(), proposta.getNome(), proposta.getId());
            analiseClient.analiseProposta(analiseRequest);
            proposta.setResultadoSolicitacao(ResultadoSolicitacao.ELEGIVEL);
        } catch (FeignException e) {
            proposta.setResultadoSolicitacao(ResultadoSolicitacao.NAO_ELEGIVEL);
        }
        propostaRepository.save(proposta);
        return ResponseEntity.created(builder.path("/api/v1/propostas/{id}").buildAndExpand(proposta.getId()).toUri()).build();
    }
}
