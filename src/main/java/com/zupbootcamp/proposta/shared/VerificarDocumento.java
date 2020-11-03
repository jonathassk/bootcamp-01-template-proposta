package com.zupbootcamp.proposta.shared;

import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import com.zupbootcamp.proposta.requests.PropostaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;

import java.util.IllegalFormatException;
import java.util.Optional;

@Component
public class VerificarDocumento {
    private final PropostaRepository propostaRepository;

    @Autowired
    public VerificarDocumento (PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

    public void verificarTamanhoCoexistencia (PropostaRequest request) {
        Optional<Proposta> propostaOptional = propostaRepository.findbyDocument(request.getDocumento());
        if (propostaOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento já cadastrado");
        }
        if (!request.getDocumento().matches("[0-9]+")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Documento preenchido incorretamente");
        }
    }
}
