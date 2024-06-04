package com.olabi.olabiflix.controller;


import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.repository.FilmeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.*;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private static final Logger log = LoggerFactory.getLogger(Filme.class);
    private final FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @GetMapping()
    public List<Filme> getFilmes() {
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Filme> getFilmesById(@PathVariable UUID id) {
        return filmeRepository.findById(id);
    }

    @GetMapping("/busca-title")
    public ResponseEntity<Filme> findByTitle(@RequestParam(name = "title", defaultValue = "") String title) {
        Optional<Filme> filmeEncontrado = filmeRepository.findByTitle(title);
        if (filmeEncontrado.isPresent()) {
            Filme filme = filmeEncontrado.get();
            return ResponseEntity.ok(filme);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/busca-genre")
    public ResponseEntity<List<Filme>> findByGenre(@RequestParam(name = "genre", defaultValue = "") String genre) {
        List<Filme> filmes = filmeRepository.findByGenreIsContainingIgnoreCase(genre);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/busca-title-actors")
    public ResponseEntity<List<Filme>> findByTitleOrActors(
            @RequestParam(name = "title", defaultValue = "") String title,
            @RequestParam(name = "actors", defaultValue = "") String actors
    ) {
        List<Filme> filmes = filmeRepository.findByTitleOrActors(title, actors);
        return ResponseEntity.ok(filmes);
    }


    @PostMapping("/criar")
    public Filme create(@RequestBody Filme filmeBody) {
        return filmeRepository.save(filmeBody);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        filmeRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> putFilme(@PathVariable UUID id, @RequestBody Filme filmeBody) {
        Optional<Filme> filmeEncontrado = filmeRepository.findById(id);



        if (filmeEncontrado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Filme filme = filmeEncontrado.get();
        log.info(String.valueOf(filme));

        filme.setTitle(filmeBody.getTitle());
        filme.setYear(filmeBody.getYear());
        filme.setRated(filmeBody.getRated());
        filme.setReleased(filmeBody.getReleased());
        filme.setRuntime(filmeBody.getRuntime());
        filme.setGenre(filmeBody.getGenre());
        filme.setDirector(filmeBody.getDirector());
        filme.setWriter(filmeBody.getWriter());
        filme.setActors(filmeBody.getActors());
        filme.setPlot(filmeBody.getPlot());
        filme.setLanguage(filmeBody.getLanguage());
        filme.setCountry(filmeBody.getCountry());
        filme.setAwards(filmeBody.getAwards());

        Filme filmeAtualizado = filmeRepository.save(filme);

        return ResponseEntity.ok(filmeAtualizado);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Filme> patchFilme(@PathVariable UUID id, @RequestBody  Map<String, String> requestBody) throws IllegalAccessException {
        Optional<Filme> filmeEncontrado = filmeRepository.findById(id);

        if (filmeEncontrado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Filme filme = filmeEncontrado.get();

        List<Field> camposDaModel = List.of(filme.getClass().getDeclaredFields());
        for (Field field : camposDaModel) {
            field.setAccessible(true);
            String nameField = field.getName();

            if(requestBody.containsKey(nameField)){
                String atualizacaoRequest = requestBody.get(nameField);
                field.set(filme, atualizacaoRequest);
            }
        }
        filmeRepository.save(filme);
        return ResponseEntity.ok(filme);
    }


}