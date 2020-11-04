package com.zupbootcamp.proposta.feing.responses;

import java.time.LocalDate;

public class Avisos {
    private final LocalDate validoAte;
    private final String destino;

    public Avisos(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
