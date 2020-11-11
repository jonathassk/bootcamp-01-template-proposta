package com.zupbootcamp.proposta.feing.requests;

public class BloqueioRequest {
    private String sistemaResponsavel;

    public BloqueioRequest (String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public BloqueioRequest () {}

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }
}
