package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.repository.SerieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("/busca-title")
    public ResponseEntity<Serie> findByTitle(@RequestParam(name = "title", defaultValue = "") String title){
        Optional<Serie> serieEncontrada = serieRepository.findByTitle(title);
        if(serieEncontrada.isPresent()){
            Serie serie = serieEncontrada.get();
            return ResponseEntity.ok(serie);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/busca-genre")
    public ResponseEntity<List<Serie>> findByGenre(@RequestParam(name = "genre",defaultValue = "") String genre){
        List<Serie> series = serieRepository.findByGenreIsContainingIgnoreCase(genre);
        return ResponseEntity.ok(series);
    }

    @GetMapping("/busca-title-actors")
    public ResponseEntity<List<Serie>> findByTitleOrActors(
            @RequestParam(name = "title", defaultValue = "") String title,
            @RequestParam(name = "actors", defaultValue = "") String actors
    ){
        List<Serie> series = serieRepository.findByTitleOrActors(title, actors);
        return ResponseEntity.ok(series);
    }


    @PostMapping("/criar")
    public Serie create(@RequestBody  Serie serieBody){
        return serieRepository.save(serieBody);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){serieRepository.deleteById(id);}
}
