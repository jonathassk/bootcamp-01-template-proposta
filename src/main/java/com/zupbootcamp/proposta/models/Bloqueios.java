package com.zupbootcamp.proposta.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Bloqueios {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    private final LocalDateTime instantBlock;
    private final String ip;
    private final String userAgent;

    public Bloqueios(LocalDateTime instantBlock, String ip, String userAgent) {
        this.instantBlock = instantBlock;
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getInstantBlock() {
        return instantBlock;
    }

    public String getIp() {
        return ip;
    }

    public String getUserAgent() {
        return userAgent;
    }
}
