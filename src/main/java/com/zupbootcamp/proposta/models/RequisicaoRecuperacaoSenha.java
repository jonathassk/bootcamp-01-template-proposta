package com.zupbootcamp.proposta.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
public class RequisicaoRecuperacaoSenha {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    private final LocalDateTime instant;
    private final String ip;
    private final String userAgent;

    public RequisicaoRecuperacaoSenha(String ip, String userAgent) {
        this.instant = LocalDateTime.now();
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public String getIp() {
        return ip;
    }

    public String getUserAgent() {
        return userAgent;
    }
}

