package com.zupbootcamp.proposta.feing.responses;

import java.math.BigDecimal;

public class Parcelas {
    private String id;
    private int quantidade;
    private BigDecimal valor;

    public Parcelas(String id, int quantidade, BigDecimal valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
