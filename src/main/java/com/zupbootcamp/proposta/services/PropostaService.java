package com.zupbootcamp.proposta.services;

import com.zupbootcamp.proposta.feing.AnaliseClient;
import com.zupbootcamp.proposta.feing.requests.AnaliseRequest;
import com.zupbootcamp.proposta.feing.responses.ResultadoSolicitacao;
import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropostaService {
    private final PropostaRepository propostaRepository;
    private final AnaliseClient analiseClient;

    @Autowired
    public PropostaService (PropostaRepository propostaRepository, AnaliseClient analiseClient) {
        this.propostaRepository = propostaRepository;
        this.analiseClient = analiseClient;
    }

    public void criarProposta (Proposta proposta) {
        try {
            AnaliseRequest analiseRequest = new AnaliseRequest(proposta.getDocumento(), proposta.getNome(), proposta.getId());
            analiseClient.analiseProposta(analiseRequest);
            proposta.setResultadoSolicitacao(ResultadoSolicitacao.ELEGIVEL);
        } catch (FeignException e) {
            proposta.setResultadoSolicitacao(ResultadoSolicitacao.NAO_ELEGIVEL);
        }
        propostaRepository.save(proposta);
    }
}
