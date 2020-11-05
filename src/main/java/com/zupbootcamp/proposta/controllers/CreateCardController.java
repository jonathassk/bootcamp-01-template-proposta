package com.zupbootcamp.proposta.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.zupbootcamp.proposta.feing.CartaoCriar;
import com.zupbootcamp.proposta.feing.requests.AnaliseRequest;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/proposta")
public class CreateCardController {
    private final CartaoCriar cartaoCriar;
    private final PropostaRepository propostaRepository;

    @Autowired
    public CreateCardController (PropostaRepository propostaRepository, CartaoCriar cartaoCriar) {
        this.propostaRepository = propostaRepository;
        this.cartaoCriar = cartaoCriar;
    }

    @Transactional
    @GetMapping("/{idProposta}/cartao")
    @ResponseStatus(HttpStatus.CREATED)
    @Scheduled(fixedRate = 10000)
    public void criarCartao (@PathVariable("idProposta") String idProposta) {
        Proposta proposta = propostaRepository.findByPropostaId(idProposta);
        Optional<CartaoResponse> response = consultaExterna(idProposta);
        response.ifPresent(cartaoResponse -> proposta.setCartaoId(cartaoResponse.getId()));
        propostaRepository.save(proposta);
    }


    @Scheduled(fixedDelayString = "${periodicidade.cartao-consulta}")
    public Optional<CartaoResponse> consultaExterna (String id) {
        return cartaoCriar.analiseProposta(id);
    }
}
