package com.samuelaraujo.gerenciadorpessoas.repository;

import com.samuelaraujo.gerenciadorpessoas.entity.Horimetro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorimetroRepository extends JpaRepository<Horimetro, Long> {
}
