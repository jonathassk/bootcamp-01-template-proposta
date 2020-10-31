package com.zupbootcamp.proposta.feing.requests;

public class AnaliseRequest {
    private String documento;
    private String nome;
    private String idProposta;

    public AnaliseRequest(String documento, String nome, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    public AnaliseRequest () {}

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
