package com.zupbootcamp.proposta.services;

import com.zupbootcamp.proposta.feing.AcoesCartao;
import com.zupbootcamp.proposta.feing.requests.BloqueioRequest;
import com.zupbootcamp.proposta.feing.responses.BloqueioResponse;
import com.zupbootcamp.proposta.models.Bloqueios;
import com.zupbootcamp.proposta.repositories.BloqueioRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BloqueioCartao {
    private final BloqueioRepository repository;
    private final AcoesCartao acoesCartao;

    @Autowired
    public BloqueioCartao (BloqueioRepository repository, AcoesCartao acoesCartao) {
        this.repository = repository;
        this.acoesCartao = acoesCartao;
    }

    public ResponseEntity<Object> bloqueio (String cartaoid, Bloqueios bloqueio, UriComponentsBuilder builder) {
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
