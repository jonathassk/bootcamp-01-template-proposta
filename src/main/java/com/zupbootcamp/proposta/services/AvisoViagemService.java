package com.zupbootcamp.proposta.services;

import com.zupbootcamp.proposta.feing.AcoesCartao;
import com.zupbootcamp.proposta.feing.responses.BloqueioResponse;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import com.zupbootcamp.proposta.models.AvisoViagem;
import com.zupbootcamp.proposta.requests.AvisoViagemRequest;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AvisoViagemService {
    private final AcoesCartao acoesCartao;
    private final Logger logger = LoggerFactory.getLogger(AvisoViagemService.class);

    @Autowired
    public AvisoViagemService (AcoesCartao acoesCartao) {
        this.acoesCartao = acoesCartao;
    }

    public ResponseEntity<Object> requisicaoExterna (String idCartao, AvisoViagemRequest avisoRequest, UriComponentsBuilder builder) {
        try {
            CartaoResponse response = acoesCartao.avisoViagem(idCartao, avisoRequest);
            logger.info("cadastrado aviso viagem");
            return ResponseEntity.created(builder.path("/api/v1/viagens/{id]").buildAndExpand(idCartao).toUri()).body(response);
        } catch (FeignException e) {
            Object response = new BloqueioResponse("FALHA");
            return ResponseEntity.status(400).body(response);
        }
    }
}
