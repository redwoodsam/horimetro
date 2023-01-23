package com.samuelaraujo.gerenciadorpessoas.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "horimetro")
public class Horimetro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    private Double horimetro;

    public Horimetro() {
    }

    public Horimetro(LocalDateTime dataHora, Double horimetro, boolean status) {
        this.dataHora = dataHora;
        this.horimetro = horimetro;
        this.status = status;
    }

    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getHorimetro() {
        return horimetro;
    }

    public void setHorimetro(Double horimetro) {
        this.horimetro = horimetro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
