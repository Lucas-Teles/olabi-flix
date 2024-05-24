package com.olabi.olabiflix.config;

import com.olabi.olabiflix.repository.FilmeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseInitializer implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DataBaseInitializer.class);

    private final FilmeRepository filmeRepository;

    public DataBaseInitializer(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Alô pepe moreno? o banco ta conectado");
        filmeRepository.saveAll(filmes);
        filmeRepository.findAll().forEach(filme -> System.out.println(filme));
    }
}
