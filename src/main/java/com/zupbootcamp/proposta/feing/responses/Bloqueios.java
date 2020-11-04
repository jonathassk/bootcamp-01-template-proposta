package com.zupbootcamp.proposta.feing.responses;

import java.time.LocalDateTime;

public class Bloqueios {
    private final String id;
    private final LocalDateTime bloqueadoEm;
    private final String sistemaResponsavel;
    private final boolean ativo;


    public Bloqueios(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Bloqueios toModel () {
        return new Bloqueios(id, bloqueadoEm, sistemaResponsavel, ativo);
    }
}
