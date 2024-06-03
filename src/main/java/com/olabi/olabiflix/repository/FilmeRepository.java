package com.olabi.olabiflix.repository;

import com.olabi.olabiflix.model.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID> {
    // DEFINIR OS METODOS QUE VAO GERAR AS QUERIES

    Optional<Filme> findByTitle(String title);

    List<Filme> findByGenreIsContainingIgnoreCase(String genre);

    List<Filme> findByTitleOrActors(String title, String actors);

}
