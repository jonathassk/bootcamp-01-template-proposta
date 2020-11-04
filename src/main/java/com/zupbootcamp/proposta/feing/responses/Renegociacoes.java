package com.zupbootcamp.proposta.feing.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Renegociacoes {
    private final String id;
    private final int quantidade;
    private final BigDecimal valor;
    private final LocalDateTime dataDeCriacao;

    public Renegociacoes(String id, int quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
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

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }
}
