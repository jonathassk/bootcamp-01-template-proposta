package com.zupbootcamp.proposta.feing.responses;

import java.time.LocalDateTime;
import java.util.Objects;

public class Carteiras {
    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;

    public Carteiras(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getAssociadaEm() {
        return associadaEm;
    }

    public String getEmissor() {
        return emissor;
    }

}
