package com.zupbootcamp.proposta.models;

import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AvisoViagem {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    @NotBlank
    private final String cartaoId;
    @NotBlank
    private final String destino;
    @NotNull
    private final LocalDate termino;
    private final LocalDateTime instant;
    private final String ip;
    private final String userAgent;

    public AvisoViagem(String cartaoId, @NotBlank  String destino, @NotNull LocalDate termino, String ip, String userAgent) {
        this.cartaoId = cartaoId;
        this.destino = destino;
        this.termino = termino;
        this.instant  = LocalDateTime.now();
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public String getId() {
        return id;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getTermino() {
        return termino;
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
