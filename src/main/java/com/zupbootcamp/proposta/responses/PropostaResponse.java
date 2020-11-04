package com.zupbootcamp.proposta.responses;

import com.zupbootcamp.proposta.feing.responses.ResultadoSolicitacao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PropostaResponse {
    private final String id;
    private final String documento;
    private final String email;
    private final String nome;
    private final String endereco;
    private final BigDecimal salario;
    private final String cartaoId;
    private final ResultadoSolicitacao resultadoSolicitacao;

    public PropostaResponse(String id, String documento, String email, String nome, String endereco, BigDecimal salario, String cartaoId, ResultadoSolicitacao resultadoSolicitacao) {
        this.id = id;
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.cartaoId = cartaoId;
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public String getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public ResultadoSolicitacao getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }
}
