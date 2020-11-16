package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.feing.AcoesCartao;
import com.zupbootcamp.proposta.models.AvisoViagem;
import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import com.zupbootcamp.proposta.repositories.ViagemRepository;
import com.zupbootcamp.proposta.requests.AvisoViagemRequest;
import com.zupbootcamp.proposta.services.AvisoViagemService;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/viagens")
public class AvisoViagemController {
    private final PropostaRepository propostaRepository;
    private final ViagemRepository viagemRepository;
    private final AvisoViagemService viagemService;
    private final AcoesCartao acoesCartao;

    public AvisoViagemController (PropostaRepository propostaRepository, ViagemRepository viagemRepository, AvisoViagemService viagemService, AcoesCartao acoesCartao) {
        this.propostaRepository = propostaRepository;
        this.viagemRepository = viagemRepository;
        this.viagemService = viagemService;
        this.acoesCartao = acoesCartao;
    }

    @Transactional
    @PostMapping("/{idCartao}")
    public ResponseEntity<Object> criarAviso (@PathVariable("idCartao") String idCartao, @Valid @RequestBody AvisoViagemRequest request, HttpServletRequest servletRequest, UriComponentsBuilder builder) {
        Object cartao;
        try {
            cartao = acoesCartao.findCartao(idCartao);
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cartão não encontrado!");
        } finally {
            viagemService.requisicaoExterna(idCartao, request, builder);
        }
        return ResponseEntity.status(200).body(cartao);
    }
}
