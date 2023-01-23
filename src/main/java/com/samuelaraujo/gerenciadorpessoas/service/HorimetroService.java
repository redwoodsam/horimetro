package com.samuelaraujo.gerenciadorpessoas.service;

import com.samuelaraujo.gerenciadorpessoas.dto.request.HorimetroRequestDTO;
import com.samuelaraujo.gerenciadorpessoas.entity.Horimetro;
import com.samuelaraujo.gerenciadorpessoas.exception.InformacaoInvalidaException;
import com.samuelaraujo.gerenciadorpessoas.exception.NaoEncontradoException;
import com.samuelaraujo.gerenciadorpessoas.repository.HorimetroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class HorimetroService {

    @Autowired
    private HorimetroRepository repository;

    public List<Horimetro> listar() {
        return repository.findAll();
    }

    public Horimetro buscarPorId(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Registro não encontrado"));
    }

    public Horimetro criar(HorimetroRequestDTO horimetroDTO) {
        LocalDateTime dataFormatada = formatarData(horimetroDTO.getDataHora());
        Horimetro horimetro =
                new Horimetro(dataFormatada, horimetroDTO.getHorimetro(), horimetroDTO.isStatus());
        return repository.save(horimetro);
    }

    public Horimetro atualizar(Long id, HorimetroRequestDTO horimetroDTO) {
        LocalDateTime dataFormatada = formatarData(horimetroDTO.getDataHora());
        Horimetro horimetroSalvo = buscarPorId(id);

        Horimetro novoHorimetro =
                new Horimetro(dataFormatada, horimetroDTO.getHorimetro(), horimetroDTO.isStatus());

        BeanUtils.copyProperties(novoHorimetro, horimetroSalvo, "id");
        return repository.save(horimetroSalvo);
    }

    public void apagar(Long id) {
        Horimetro horimetroSalvo = buscarPorId(id);
        repository.delete(horimetroSalvo);
    }

    /* Métodos utilitários */
    private LocalDateTime formatarData(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            return LocalDateTime.parse(data, formatter);
        } catch (Exception ex) {
            throw new InformacaoInvalidaException("Data inválida");
        }
    }
}
