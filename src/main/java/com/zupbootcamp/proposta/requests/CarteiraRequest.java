package com.zupbootcamp.proposta.requests;

import com.zupbootcamp.proposta.models.Carteira;

import javax.validation.constraints.NotBlank;

public class CarteiraRequest {
    @NotBlank
    private final String email;
    @NotBlank
    private final String carteira;

    public CarteiraRequest(@NotBlank String email, @NotBlank String carteira) {
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
