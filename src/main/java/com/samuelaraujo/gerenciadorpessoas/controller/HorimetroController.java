package com.samuelaraujo.gerenciadorpessoas.controller;

import com.samuelaraujo.gerenciadorpessoas.dto.request.HorimetroRequestDTO;
import com.samuelaraujo.gerenciadorpessoas.dto.response.HorimetroResponseDTO;
import com.samuelaraujo.gerenciadorpessoas.service.HorimetroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/horimetro")
public class HorimetroController {

    @Autowired
    private HorimetroService service;

    @GetMapping
    public List<HorimetroResponseDTO> listar() {
        return service.listar()
                .stream()
                .map(horimetro -> HorimetroResponseDTO.from(horimetro))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorimetroResponseDTO> buscarPorId(@PathVariable Long id) {
        HorimetroResponseDTO resposta = HorimetroResponseDTO.from(service.buscarPorId(id));
        return ResponseEntity.ok(resposta);
    }

    @PostMapping
    public ResponseEntity<HorimetroResponseDTO> criar(@Valid @RequestBody HorimetroRequestDTO horimetroDTO) {
        HorimetroResponseDTO resposta = HorimetroResponseDTO.from(service.criar(horimetroDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorimetroResponseDTO> atualizar(@PathVariable Long id,
                                                          @Valid @RequestBody HorimetroRequestDTO horimetroDTO) {
        HorimetroResponseDTO resposta = HorimetroResponseDTO.from(service.atualizar(id, horimetroDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> apagar(@PathVariable Long id) {
        service.apagar(id);
        return ResponseEntity.noContent().build();
    }
}
