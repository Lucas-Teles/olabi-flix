package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.repository.FilmeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/criar")
    public Filme create(@RequestBody Filme filmeBody){
        return filmeRepository.save(filmeBody);
    }
}
