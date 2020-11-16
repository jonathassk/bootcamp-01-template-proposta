package com.zupbootcamp.proposta.requests;

import com.zupbootcamp.proposta.models.AvisoViagem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AvisoViagemRequest {
    @NotBlank
    private final String destino;
    @NotNull
    private final LocalDate validoAte;

    public AvisoViagemRequest(@NotBlank String destino, @NotNull LocalDate validoAte) {
        this.destino = destino;
        this.validoAte = validoAte;
    }

    public AvisoViagem toModel (String cartaoId, String ip, String userAgent) {
        return new AvisoViagem(cartaoId, destino, validoAte, ip, userAgent);
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }
}
