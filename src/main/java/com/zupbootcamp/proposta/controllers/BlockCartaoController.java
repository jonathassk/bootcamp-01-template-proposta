package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.feing.AcoesCartao;
import com.zupbootcamp.proposta.feing.requests.BloqueioRequest;
import com.zupbootcamp.proposta.feing.responses.BloqueioResponse;
import com.zupbootcamp.proposta.models.Bloqueios;
import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.BloqueioRepository;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/{cartaoId}/block")
public class BlockCartaoController {
    private final BloqueioRepository repository;
    private final PropostaRepository propostaRepository;
    private final AcoesCartao acoesCartao;

    @Autowired
    public BlockCartaoController (BloqueioRepository repository, PropostaRepository propostaRepository, AcoesCartao acoesCartao) {
        this.repository = repository;
        this.propostaRepository = propostaRepository;
        this.acoesCartao = acoesCartao;
    }

    @GetMapping
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> blockCartao (HttpServletRequest request, @PathVariable("cartaoId") String cartaoid, UriComponentsBuilder builder) {
        Proposta proposta = propostaRepository.findByCartaoId(cartaoid);
        if (proposta == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cartão não encontrado");
        }
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        Bloqueios bloqueio = new Bloqueios(LocalDateTime.now(), ip, userAgent);
        repository.save(bloqueio);
        Object response = new Object();
        try {
            BloqueioRequest bloqueioReq = new BloqueioRequest("sistemaResponsavel");
            response = acoesCartao.bloqueioCartao(cartaoid, bloqueioReq);
            return ResponseEntity.created(builder.path("/api/v1/bloqueio/{id}").buildAndExpand(bloqueio.getId()).toUri()).body(response);
        } catch (FeignException e) {
            response = new BloqueioResponse("FALHA");
            return ResponseEntity.status(404).body(response);
        }
    }

}
