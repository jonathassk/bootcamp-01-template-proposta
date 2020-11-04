package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.feing.CartaoCriar;
import com.zupbootcamp.proposta.feing.requests.AnaliseRequest;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cartao")
public class CreateCardController {
    private final CartaoCriar cartaoCriar;
    private final PropostaRepository propostaRepository;

    @Autowired
    public CreateCardController (PropostaRepository propostaRepository, CartaoCriar cartaoCriar) {
        this.propostaRepository = propostaRepository;
        this.cartaoCriar = cartaoCriar;
    }

    @Transactional
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCartao (AnaliseRequest dados, Proposta proposta) {
        Optional<CartaoResponse> response = consultaExterna(dados);
        response.ifPresent(cartaoResponse -> proposta.setCartaoId(cartaoResponse.getId()));
        propostaRepository.save(proposta);
    }

    @Scheduled(fixedDelay = 1000)
    public Optional<CartaoResponse> consultaExterna (AnaliseRequest dados) {
        return cartaoCriar.analiseProposta(dados.getIdProposta());
    }
}
