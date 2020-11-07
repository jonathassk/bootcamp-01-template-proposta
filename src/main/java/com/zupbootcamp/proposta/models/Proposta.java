package com.zupbootcamp.proposta.models;

import com.zupbootcamp.proposta.feing.responses.ResultadoSolicitacao;
import com.zupbootcamp.proposta.requests.BiometriaRequest;
import com.zupbootcamp.proposta.responses.PropostaResponse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    private String documento;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull
    @Positive
    private BigDecimal salario;
    private String cartaoId;
    private ResultadoSolicitacao resultadoSolicitacao;
    private String biometria;


    public Proposta(String documento, @Email @NotBlank String email, @NotBlank String nome, @NotBlank String endereco, @NotNull @Positive BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;

    }

    @Deprecated
    public Proposta() {
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public void setResultadoSolicitacao(ResultadoSolicitacao resultadoSolicitacao) {
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public ResultadoSolicitacao getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public void setCartaoId(String cartaoId) {
        this.cartaoId = cartaoId;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setBiometria(String biometria) {
        this.biometria = biometria;
    }

    public String getBiometria() {
        return biometria;
    }
}
