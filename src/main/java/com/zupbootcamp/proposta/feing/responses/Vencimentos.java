package com.zupbootcamp.proposta.feing.responses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vencimentos {
    private final LocalDateTime dataDeCriacao;
    private final String id;
    private String dia;

    public Vencimentos(LocalDateTime dataDeCriacao, String id, String dia) {
        this.dataDeCriacao = dataDeCriacao;
        this.id = id;
        this.dia = dia;
    }

    public LocalDateTime getValidoAte() {
        return dataDeCriacao;
    }

    public String getDia() {
        return dia;
    }

    public String getId() {
        return id;
    }
}
