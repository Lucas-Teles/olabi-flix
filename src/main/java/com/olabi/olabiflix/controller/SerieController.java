package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.repository.SerieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/series")
public class SerieController {
    private final SerieRepository serieRepository;

    public SerieController(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @GetMapping()
    public List<Serie> getSeries(){
        return serieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Serie getSerieById(@PathVariable(value = "id") UUID id){
        return serieRepository.findById(id).orElse(null);
    }

    @PostMapping("/criar")
    public Serie create(@RequestBody  Serie serieBody){
        return serieRepository.save(serieBody);
    }
}
