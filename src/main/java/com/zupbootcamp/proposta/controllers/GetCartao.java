package com.zupbootcamp.proposta.controllers;

import com.zupbootcamp.proposta.feing.CartaoCriar;
import com.zupbootcamp.proposta.feing.responses.CartaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cartao")
public class GetCartao {
    private CartaoCriar cartaoCriar;

    @Autowired
    public GetCartao (CartaoCriar cartaoCriar) {
        this.cartaoCriar = cartaoCriar;
    }

    @GetMapping("/{id}")
    public CartaoResponse getCartao (@PathVariable("id") String id) {
        return cartaoCriar.analiseProposta(id);
    }
}
