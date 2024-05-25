package com.olabi.olabiflix.config;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.repository.FilmeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataBaseInitializer implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DataBaseInitializer.class);

    private final FilmeRepository filmeRepository;

    public DataBaseInitializer(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    public static final List<Filme> filmes = List.of(
            new Filme("10 Things I Hate About You","1999","PG-13","31 Mar 1999","97 min","Comedy, Drama, Romance","Gil Junger","Karen McCullah, Kirsten Smith, William Shakespeare","Heath Ledger, Julia Stiles, Joseph Gordon-Levitt","A high-school boy, Cameron, cannot date Bianca until her anti-social older sister, Kat, has a boyfriend. So, Cameron pays a mysterious boy, Patrick, to charm Kat.","English, French","United States","2 wins & 13 nominations"),
            new Filme("Inception","2010","PG-13","16 Jul 2010","148 min","Action, Adventure, Sci-Fi, Thriller","Christopher Nolan","Christopher Nolan","Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.","English, Japanese, French","United States, United Kingdom","Won 4 Oscars. 159 wins & 220 nominations total")
    );

    @Override
    public void run(String... args) throws Exception {
        log.info("Alô pepe moreno? o banco ta conectado");
        filmeRepository.saveAll(filmes);
        filmeRepository.findAll().forEach(filme -> System.out.println(filme));
    }
}
