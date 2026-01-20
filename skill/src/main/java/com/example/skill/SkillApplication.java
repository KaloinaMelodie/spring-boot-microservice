package com.example.skill;

import com.example.skill.entities.Competence;
import com.example.skill.repository.CompetenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class SkillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(CompetenceRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new Competence( "Java"),
                    new Competence( "Spring Boot"),
                    new Competence( "Docker"),
                    new Competence( "Kubernetes")
            ));
        };
    }

}
