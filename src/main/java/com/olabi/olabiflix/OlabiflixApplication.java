package com.olabi.olabiflix;

import com.olabi.olabiflix.repository.SerieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class OlabiflixApplication {

	private final SerieRepository serieRepository;

	public OlabiflixApplication(SerieRepository serieRepository){
        this.serieRepository = serieRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(OlabiflixApplication.class, args);
	}
}
