package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.feing.AcoesCartao;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import com.zupbootcamp.proposta.feing.responses.CarteiraResponse;
import com.zupbootcamp.proposta.requests.CarteiraRequest;
import com.zupbootcamp.proposta.services.CarteiraService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RequestMapping("/api/v1/carteira")
@RestController
public class AdicionarCarteiraController {
    private final AcoesCartao acoesCartao;
    private final CarteiraService carteiraService;

    @Autowired
    public AdicionarCarteiraController (AcoesCartao acoesCartao, CarteiraService carteiraService) {
        this.acoesCartao = acoesCartao;
        this.carteiraService = carteiraService;
    }


    @PostMapping("/{cartaoId}")
    @Transactional
    public ResponseEntity<CarteiraResponse> adicionarCarteira (UriComponentsBuilder builder, @Valid @RequestBody CarteiraRequest request, @PathVariable("cartaoId") String idCartao) {
        CartaoResponse cartao;
        try {
            cartao = acoesCartao.findCartao(idCartao);
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cartão não encontrado!");
        }
        return carteiraService.requisicaoExterna(idCartao, request, builder, cartao);
    }
}
