package com.samuelaraujo.gerenciadorpessoas.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class HorimetroRequestDTO implements Serializable {

    @NotBlank(message = "O campo Data e Hora é obrigatório")
    private String dataHora;

    @NotNull(message = "O campo Horímetro é obrigatório")
    private Double horimetro;
    @NotNull(message = "O campo Status é obrigatório")
    private boolean status;

    public HorimetroRequestDTO() {
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
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
