package com.zupbootcamp.proposta.models;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
//    private LocalDate emitidoEm;
//    private String titular;
//    private Bloqueio bloqueio;
//    private Aviso aviso;
//    private Carteira carteira;
//    private Parcela parcela;
//    private BigDecimal limite;
//    private Renegociacao renegociacao;
//    private Vencimento vencimento;
//    private String idProposta;

}
