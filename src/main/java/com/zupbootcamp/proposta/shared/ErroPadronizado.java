package com.zupbootcamp.proposta.shared;

import java.util.Collection;

public class ErroPadronizado {
    private Collection<String> mensagens;

    public ErroPadronizado(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public ErroPadronizado() {
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }
}
