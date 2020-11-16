package com.zupbootcamp.proposta.services;

import com.zupbootcamp.proposta.feing.AcoesCartao;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import com.zupbootcamp.proposta.feing.responses.CarteiraResponse;
import com.zupbootcamp.proposta.feing.responses.Carteiras;
import com.zupbootcamp.proposta.repositories.CarteiraRepository;
import com.zupbootcamp.proposta.requests.CarteiraRequest;
import feign.FeignException;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarteiraService {
    private final AcoesCartao acoesCartao;
    private CarteiraRepository carteiraRepository;

    @Autowired
    public CarteiraService (AcoesCartao acoesCartao, CarteiraRepository carteiraRepository) {
        this.acoesCartao = acoesCartao;
        this.carteiraRepository = carteiraRepository;
    }

    public ResponseEntity<CarteiraResponse> requisicaoExterna(String idCartao, CarteiraRequest request, UriComponentsBuilder builder, CartaoResponse cartao) {
        List<Carteiras> verificarConexaoCarteira = cartao.getCarteiras().stream().filter(item -> item.getEmissor().equals(request.getCarteira())).collect(Collectors.toList());
        if (!verificarConexaoCarteira.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "já foi cadastrada essa carteira");
        }
        CarteiraResponse response = acoesCartao.vincularCarteira(idCartao, request);;
        return ResponseEntity.created(builder.path("/api/v1/carteira/{id}").buildAndExpand(response.getId()).toUri()).build();
    }
}
