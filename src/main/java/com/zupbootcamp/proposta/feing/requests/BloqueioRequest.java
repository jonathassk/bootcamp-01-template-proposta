package com.zupbootcamp.proposta.feing.requests;

public class BloqueioRequest {
    private final String sistemaResponsavel;

    public BloqueioRequest (String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }
}
