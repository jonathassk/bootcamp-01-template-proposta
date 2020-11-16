package com.zupbootcamp.proposta.requests;

import com.zupbootcamp.proposta.models.Carteira;

public class CarteiraRequest {
    private final String email;
    private final String carteira;

    public CarteiraRequest(String email, String carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }

    public Carteira toModel (String cartaoId) {
        return new Carteira(cartaoId, carteira);
    }
}
