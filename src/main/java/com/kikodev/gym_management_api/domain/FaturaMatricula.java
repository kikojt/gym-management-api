package com.kikodev.gym_management_api.domain;

import com.kikodev.gym_management_api.domain.enums.EstadoFatura;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "faturas_matriculas")
public class FaturaMatricula {

    // Variáveis de Instância
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @Column(name = "data_cancelamento")
    private LocalDate dataCancelamento;

    @Enumerated(EnumType.STRING)
    private EstadoFatura estado = EstadoFatura.PENDENTE;

    // Relacionamento com Matricula
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;


    // Construtores


    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(LocalDate dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public EstadoFatura getEstado() {
        return estado;
    }

    public void setEstado(EstadoFatura estado) {
        this.estado = estado;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
}
