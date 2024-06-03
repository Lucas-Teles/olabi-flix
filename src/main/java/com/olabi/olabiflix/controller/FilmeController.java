package com.olabi.olabiflix.controller;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.repository.FilmeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public Optional<Filme> getFilmesById(@PathVariable UUID id){
        return filmeRepository.findById(id);
    }

    @GetMapping("/busca-title")
    public ResponseEntity<Filme> findByTitle(@RequestParam(name = "title", defaultValue = "") String title){
        Optional<Filme> filmeEncontrado = filmeRepository.findByTitle(title);
        if(filmeEncontrado.isPresent()){
            Filme filme = filmeEncontrado.get();
            return ResponseEntity.ok(filme);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/busca-genre")
    public ResponseEntity<List<Filme>> findByGenre(@RequestParam(name = "genre",defaultValue = "") String genre){
        List<Filme> filmes = filmeRepository.findByGenreIsContainingIgnoreCase(genre);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/busca-title-actors")
    public ResponseEntity<List<Filme>> findByTitleOrActors(
            @RequestParam(name = "title", defaultValue = "") String title,
            @RequestParam(name = "actors", defaultValue = "") String actors) {
        List<Filme> filmes = filmeRepository.findByTitleOrActors(title, actors);
        return ResponseEntity.ok(filmes);
    }


    @PostMapping("/criar")
    public Filme create(@RequestBody Filme filmeBody){
        return filmeRepository.save(filmeBody);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        filmeRepository.deleteById(id);
    }
}
