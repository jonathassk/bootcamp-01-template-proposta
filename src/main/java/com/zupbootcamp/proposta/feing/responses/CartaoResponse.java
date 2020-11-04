package com.zupbootcamp.proposta.feing.responses;

import java.time.LocalDateTime;
import java.util.*;

public class CartaoResponse {
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private String idProposta;
    private List<Bloqueios> bloqueios = new ArrayList<>();
    private List<Avisos> avisos = new ArrayList<>();
    private List<Carteiras> carteiras = new ArrayList<>();
    private List<Renegociacoes> parcelas = new ArrayList<>();
    private List<Parcelas> renegociacoes = new ArrayList<>();
    private List<Vencimentos> vencimentos = new ArrayList<>();

    public CartaoResponse(String id, LocalDateTime emitidoEm, String titular, String idProposta, List<Bloqueios> bloqueios, List<Avisos> avisos, List<Carteiras> carteiras, List<Renegociacoes> parcelas, List<Parcelas> renegociacoes, List<Vencimentos> vencimentos) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.idProposta = idProposta;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.renegociacoes = renegociacoes;
        this.vencimentos = vencimentos;
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

    public List<Bloqueios> getBloqueios() {
        return bloqueios;
    }

    public List<Avisos> getAvisos() {
        return avisos;
    }

    public List<Carteiras> getCarteiras() {
        return carteiras;
    }

    public List<Renegociacoes> getParcelas() {
        return parcelas;
    }

    public List<Parcelas> getRenegociacoes() {
        return renegociacoes;
    }

    public List<Vencimentos> getVencimentos() {
        return vencimentos;
    }
}
