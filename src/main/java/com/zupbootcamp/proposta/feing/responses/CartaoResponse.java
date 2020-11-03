package com.zupbootcamp.proposta.feing.responses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CartaoResponse {
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private String idProposta;

    public CartaoResponse(String id, LocalDateTime emitidoEm, String titular, String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.idProposta = idProposta;
    }

    public CartaoResponse () {}

    public String getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
