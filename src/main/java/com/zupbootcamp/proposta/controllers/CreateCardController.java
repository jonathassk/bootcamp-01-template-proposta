package com.zupbootcamp.proposta.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/cartao")
public class CreateCardController {

    @Transactional
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCartao () {

    }
}
