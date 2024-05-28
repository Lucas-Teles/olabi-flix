package com.olabi.olabiflix.config;

import com.olabi.olabiflix.model.entity.Filme;
import com.olabi.olabiflix.model.entity.Serie;
import com.olabi.olabiflix.model.value.Ratings;
import com.olabi.olabiflix.repository.FilmeRepository;
import com.olabi.olabiflix.repository.SerieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataBaseInitializer implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DataBaseInitializer.class);

    private final FilmeRepository filmeRepository;
    private final SerieRepository serieRepository;

    public DataBaseInitializer(FilmeRepository filmeRepository, SerieRepository serieRepository){
        this.filmeRepository = filmeRepository;
        this.serieRepository = serieRepository;
    }

    public static final List<Filme> filmes = List.of(
            new Filme("10 Coisas Que Eu Odeio em Você", "1999", "PG-13", "31 Mar 1999", "97 min", "Comédia, Drama, Romance", "Gil Junger", "Karen McCullah, Kirsten Smith", "Heath Ledger, Julia Stiles, Joseph Gordon-Levitt, Larisa Oleynik", "Uma adolescente bonita e popular não pode sair em um encontro até que sua irmã mais velha mal-humorada o faça.", "Inglês, Francês", "EUA", "2 vitórias e 13 indicações."),
            new Filme("Avatar", "2009", "PG-13", "18 Dez 2009", "162 min", "Ação, Aventura, Fantasia, Ficção Científica", "James Cameron", "James Cameron", "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang", "Um fuzileiro paraplégico enviado à lua Pandora em uma missão única fica dividido entre seguir suas ordens e proteger o mundo que sente ser sua casa.", "Inglês, Espanhol", "EUA", "Ganhou 3 Oscars. Outros 86 vitórias e 129 indicações."),
            new Filme("A Origem", "2010", "PG-13", "16 Jul 2010", "148 min", "Ação, Aventura, Ficção Científica, Suspense", "Christopher Nolan", "Christopher Nolan", "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Tom Hardy", "Um ladrão que rouba segredos corporativos usando a tecnologia de compartilhamento de sonhos é dado a tarefa inversa de plantar uma ideia na mente de um C.E.O.", "Inglês, Japonês, Francês", "EUA, Reino Unido", "Ganhou 4 Oscars. Outros 152 vitórias e 217 indicações."),
            new Filme("Doutor Estranho", "2016", "PG-13", "04 Nov 2016", "115 min", "Ação, Aventura, Fantasia, Ficção Científica", "Scott Derrickson", "Jon Spaihts, Scott Derrickson, C. Robert Cargill, Stan Lee (baseado nos quadrinhos da Marvel), Steve Ditko (baseado nos quadrinhos da Marvel)", "Benedict Cumberbatch, Chiwetel Ejiofor, Rachel McAdams, Benedict Wong", "Enquanto busca cura física e espiritual, um brilhante neurocirurgião é atraído para o mundo das artes místicas.", "Inglês", "EUA", "Indicado a 1 Oscar. Outros 20 vitórias e 65 indicações."),
            new Filme("O Show de Truman", "1998", "PG", "05 Jun 1998", "103 min", "Comédia, Drama, Ficção Científica", "Peter Weir", "Andrew Niccol", "Jim Carrey, Laura Linney, Noah Emmerich, Natascha McElhone", "Um vendedor de seguros descobre que sua vida inteira é, na verdade, um programa de TV.", "Inglês", "EUA", "Indicado a 3 Oscars. Outros 40 vitórias e 66 indicações."),
            new Filme("Besouro", "2009", "N/A", "30 Out 2009", "95 min", "Ação, Drama", "João Daniel Tikhomiroff", "Patrícia Andrade", "Aílton Carmo, Jessica Barbosa, Flávio Rocha", "A história do lendário capoeirista Besouro Mangangá, ambientada no Brasil dos anos 1920.", "Português", "Brasil", "1 vitória e 2 indicações."),
            new Filme("O Auto da Compadecida", "2000", "N/A", "15 Set 2000", "104 min", "Comédia, Drama", "Guel Arraes", "Guel Arraes, Adriana Falcão", "Matheus Nachtergaele, Selton Mello, Denise Fraga", "As aventuras de João Grilo e Chicó no sertão nordestino, adaptado da peça de Ariano Suassuna.", "Português", "Brasil", "Ganhou 5 prêmios."),
            new Filme("Planeta dos Macacos", "1968", "G", "03 Abr 1968", "112 min", "Aventura, Drama, Ficção Científica", "Franklin J. Schaffner", "Michael Wilson, Rod Serling", "Charlton Heston, Roddy McDowall, Kim Hunter", "Um astronauta cai em um planeta distante dominado por uma civilização de macacos que tratam os humanos como escravos.", "Inglês", "EUA", "Ganhou 1 Oscar. Outros 3 vitórias e 2 indicações."),
            new Filme("Homem-Aranha no Aranhaverso", "2018", "PG", "14 Dez 2018", "117 min", "Animação, Ação, Aventura", "Peter Ramsey, Rodney Rothman", "Phil Lord, Rodney Rothman", "Shameik Moore, Jake Johnson, Hailee Steinfeld", "Miles Morales se torna o Homem-Aranha de sua realidade e cruza caminhos com seus homólogos de outras dimensões para deter uma ameaça a todas as realidades.", "Inglês, Espanhol", "EUA", "Ganhou 1 Oscar. Outros 75 vitórias e 53 indicações.")
    );

    public static final List<Serie> series = List.of(
            new Serie("The Last of Us", "1", new ArrayList<>(List.of("Ação", "Aventura", "Drama")), new ArrayList<>(List.of("Neil Druckmann")), "https://br.web.img3.acsta.net/pictures/22/11/30/19/53/5856320.jpg", new ArrayList<>(List.of("Pedro Pascal", "Bella Ramsey", "Gabriel Luna")), new Ratings("9.3", "132131")),
            new Serie("La Casa de Papel", "5", new ArrayList<>(List.of("Ação", "Crime", "Mistério")), new ArrayList<>(List.of("Álex Pina")), "https://images.justwatch.com/poster/270389468/s718/temporada-1.jpg", new ArrayList<>(List.of("Úrsula Corberó", "Álvaro Morte", "Itziar Ituño")), new Ratings("8.3", "234567")),
            new Serie("Game of Thrones", "8", new ArrayList<>(List.of("Ação", "Aventura", "Drama")), new ArrayList<>(List.of("David Benioff", "D.B. Weiss")), "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg", new ArrayList<>(List.of("Emilia Clarke", "Peter Dinklage", "Kit Harington")), new Ratings("9.2", "1938471")),
            new Serie("Breaking Bad", "5", new ArrayList<>(List.of("Crime", "Drama", "Suspense")), new ArrayList<>(List.of("Vince Gilligan")), "https://m.media-amazon.com/images/I/91RNSMNJlsL._AC_SL1500_.jpg", new ArrayList<>(List.of("Bryan Cranston", "Aaron Paul", "Anna Gunn")), new Ratings("9.5", "1637137")),
            new Serie("O Gambito da Rainha", "1", new ArrayList<>(List.of("Drama")), new ArrayList<>(List.of("Scott Frank")), "https://m.media-amazon.com/images/I/91zKdv7ZGHL._AC_SL1500_.jpg", new ArrayList<>(List.of("Anya Taylor-Joy", "Chloe Pirrie", "Bill Camp")), new Ratings("8.6", "421234")),
            new Serie("One Piece (Live Action)", "1", new ArrayList<>(List.of("Ação", "Aventura", "Fantasia")), new ArrayList<>(List.of("Matt Owens", "Steven Maeda")), "https://m.media-amazon.com/images/I/81UlpC+BEvL._AC_SL1500_.jpg", new ArrayList<>(List.of("Iñaki Godoy", "Emily Rudd", "Mackenyu")), new Ratings("8.0", "75231")),
            new Serie("Wandinha", "1", new ArrayList<>(List.of("Comédia", "Crime", "Família")), new ArrayList<>(List.of("Alfred Gough", "Miles Millar")), "https://m.media-amazon.com/images/I/81iVdMmsl-L._AC_SL1500_.jpg", new ArrayList<>(List.of("Jenna Ortega", "Gwendoline Christie", "Riki Lindhome")), new Ratings("8.1", "321654"))
    );
    @Override
    public void run(String... args) throws Exception {
        log.info("Alô pepe moreno? o banco ta conectado");
        log.info("Inserido filmes...");
        log.info("+++++++++++++++++++");
        filmeRepository.saveAll(filmes);
        log.info("Filmes inseridos com sucesso !!");
        log.info("---- ---- ---- ----");
        log.info("Inserido series...");
        log.info("+++++++++++++++++++");
        serieRepository.saveAll(series);
        log.info("Series inseridas com sucesso !!");
    }
}
