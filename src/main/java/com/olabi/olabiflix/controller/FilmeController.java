package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.repository.FilmeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @GetMapping()
    public List<Filme> getFilmes(){
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Filme getFilmesById(@PathVariable(value = "id") UUID id){
        return filmeRepository.findById(id).orElse(null);
    }

    @PostMapping("/criar")
    public Filme create(@RequestBody Filme filmeBody){
        return filmeRepository.save(filmeBody);
    }
}
