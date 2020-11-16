package com.zupbootcamp.proposta.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Carteira {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    @NotBlank
    private final String cartaoId;
    @NotBlank
    private final String carteira;

    public Carteira(@NotBlank String cartaoId, @NotBlank String carteira) {
        this.cartaoId = cartaoId;
        this.carteira = carteira;
    }

    public String getId() {
        return id;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getCarteira() {
        return carteira;
    }
}
