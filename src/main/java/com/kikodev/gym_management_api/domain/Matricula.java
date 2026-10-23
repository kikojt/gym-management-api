package com.kikodev.gym_management_api.domain;

import com.kikodev.gym_management_api.domain.enums.EstadoMatricula;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
public class Matricula {

    // Variáveis de Instância
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "dia_vencimento")
    private Integer diaVencimento;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    private EstadoMatricula estado = EstadoMatricula.ATIVA;

    // Relacionamento com Aluno
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    // Construtores


    // Métodos de lifecycle
    @PrePersist
    public void prePersist() {
        if (dataInicio == null) {
            dataInicio = LocalDate.now();
        }
    }


    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public EstadoMatricula getEstado() {
        return estado;
    }

    public void setEstado(EstadoMatricula estado) {
        this.estado = estado;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
