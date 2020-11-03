package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.feing.CartaoCriar;
import com.zupbootcamp.proposta.feing.requests.AnaliseRequest;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import com.zupbootcamp.proposta.models.Cartao;
import com.zupbootcamp.proposta.repositories.CartaoRepository;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/cartao")
public class CreateCardController {
    private final CartaoCriar cartaoCriar;
    private final CartaoRepository cartaoRepository;

    @Autowired
    public CreateCardController (CartaoRepository cartaoRepository, CartaoCriar cartaoCriar) {
        this.cartaoRepository = cartaoRepository;
        this.cartaoCriar = cartaoCriar;
    }

    @Transactional
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCartao (AnaliseRequest dados) {
        CartaoResponse response = consultaExterna(dados);
    }

    @Scheduled(fixedDelay = 1000)
    public CartaoResponse consultaExterna (AnaliseRequest dados) {
        return cartaoCriar.analiseProposta(dados.getIdProposta());
    }
}
