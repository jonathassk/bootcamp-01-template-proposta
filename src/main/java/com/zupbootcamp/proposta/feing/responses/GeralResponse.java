package com.zupbootcamp.proposta.feing.responses;

public class GeralResponse {
    private String id;
    private final String resultado;

    public GeralResponse(String id, String resultado) {
        this.id = id;
        this.resultado = resultado;
    }

    public GeralResponse(String resultado) {
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public String getResultado() {
        return resultado;
    }
}
