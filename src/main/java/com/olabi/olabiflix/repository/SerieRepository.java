package com.olabi.olabiflix.repository;

import com.olabi.olabiflix.model.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SerieRepository extends JpaRepository<Serie, UUID>{

}
