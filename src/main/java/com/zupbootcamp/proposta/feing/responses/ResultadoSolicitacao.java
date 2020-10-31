package com.zupbootcamp.proposta.feing.responses;

public enum ResultadoSolicitacao {
    NAO_ELEGIVEL(1),
    ELEGIVEL(2),
    SEM_RESTRICAO(3),
    COM_RESTRICAO(4);;

    private final int code;

    private ResultadoSolicitacao (int code) {
        this.code = code;
    }

    public int getCode () {
        return code;
    }

    public static ResultadoSolicitacao valueOf(int code) {
        for (ResultadoSolicitacao value : ResultadoSolicitacao.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("invalid UserStatus code!");
    }
}
