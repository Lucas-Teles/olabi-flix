package com.olabi.olabiflix.repository;

import com.olabi.olabiflix.model.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID> {
    // DEFINIR OS METODOS QUE VAO GERAR AS QUERIES
}
