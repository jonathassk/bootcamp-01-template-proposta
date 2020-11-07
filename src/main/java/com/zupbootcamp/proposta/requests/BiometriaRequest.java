package com.zupbootcamp.proposta.requests;

import javax.validation.constraints.NotEmpty;

public class BiometriaRequest {
    @NotEmpty(message = "a biometria precisa ser preenchida")
    private String biometria;

    public BiometriaRequest (@NotEmpty(message = "a biometria precisa ser preenchida") String biometria) {
        this.biometria = biometria;
    }

    public BiometriaRequest () {}

    public String getBiometria() {
        return biometria;
    }

}
