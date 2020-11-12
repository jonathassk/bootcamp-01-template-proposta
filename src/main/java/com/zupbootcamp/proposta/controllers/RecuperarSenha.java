package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.models.Proposta;
import com.zupbootcamp.proposta.models.RequisicaoRecuperacaoSenha;
import com.zupbootcamp.proposta.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/senha")
public class RecuperarSenha {
    @Autowired
    private PropostaRepository propostaRepositoryrepository;
    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<String> recuperarSenha (@PathVariable("idCartao") String idCartao, HttpServletRequest request, UriComponentsBuilder builder) {
        Proposta proposta = propostaRepositoryrepository.findByCartaoId(idCartao);
        if (proposta == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cartao não encontrado");
        }
        RequisicaoRecuperacaoSenha req = new RequisicaoRecuperacaoSenha(request.getRemoteAddr(), request.getHeader("User-Agent"));
        manager.persist(req);
        return ResponseEntity.created(builder.path("/api/v1/recuperar/{id}").buildAndExpand(req.getId()).toUri()).build();
    }
}

