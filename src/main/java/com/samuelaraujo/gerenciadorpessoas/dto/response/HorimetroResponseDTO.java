package com.samuelaraujo.gerenciadorpessoas.dto.response;

import com.samuelaraujo.gerenciadorpessoas.entity.Horimetro;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HorimetroResponseDTO implements Serializable {

    private Long id;
    private LocalDateTime dataHora;
    private Double horimetro;
    private boolean status;

    public HorimetroResponseDTO() {
    }

    private HorimetroResponseDTO(Long id, LocalDateTime dataHora, Double horimetro, boolean status) {
        this.id = id;
        this.dataHora = dataHora;
        this.horimetro = horimetro;
        this.status = status;
    }

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

    public static HorimetroResponseDTO from(Horimetro horimetro) {
        return new HorimetroResponseDTO(horimetro.getId(),
                horimetro.getDataHora(),
                horimetro.getHorimetro(),
                horimetro.isStatus());
    }
}
