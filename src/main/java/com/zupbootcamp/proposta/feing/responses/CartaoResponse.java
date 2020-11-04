package com.zupbootcamp.proposta.feing.responses;

import java.time.LocalDateTime;
import java.util.*;

public class CartaoResponse {
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private String idProposta;
    private Set<Bloqueios> bloqueios = new HashSet<>();

    public CartaoResponse(String id, LocalDateTime emitidoEm, String titular, String idProposta, Set<Bloqueios> bloqueios) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.idProposta = idProposta;
        this.bloqueios = bloqueios;
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

    public Set<Bloqueios> getBloqueios() {
        return bloqueios;
    }
}
