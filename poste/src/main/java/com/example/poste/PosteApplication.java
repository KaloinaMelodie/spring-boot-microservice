package com.example.poste;

import com.example.poste.client.CompetenceClient;
import com.example.poste.entities.Poste;
import com.example.poste.models.Competence;
import com.example.poste.repository.PosteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class PosteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosteApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PosteRepository repository, CompetenceClient competenceClient) {
        return args -> {
            List<Poste> list = List.of(
                    Poste.builder()
                            .id("CTO")
                            .poste("Chief Technology Officer")
                            .competencesId(List.of(1L, 2L))
                            .build(),
                    Poste.builder()
                            .id("DEV")
                            .poste("Développeur Full Stack")
                            .competencesId(List.of(1L, 2L, 3L))
                            .build()
            );
//            list.forEach((poste -> {
//                List<Competence> comps = new ArrayList<>();
//                poste.getCompetencesId().forEach(competenceId -> {
//                    Competence competence = competenceClient.getCompetenceById(competenceId);
//                    comps.add(competence);
//                });
//                poste.setCompetences(comps);
//                repository.save(poste);
//            }));

            repository.saveAll(list);

        };
    }
}
