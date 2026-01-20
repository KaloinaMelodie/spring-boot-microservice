package com.example.poste.client;

import com.example.poste.models.Competence;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="COMPETENCE")
public interface CompetenceClient {
    @GetMapping("/skills")
    @CircuitBreaker(name = "skills", fallbackMethod = "getAllCompetences")
    List<Competence> getAll();

    @GetMapping("/skill/{id}")
    @CircuitBreaker(name = "skills", fallbackMethod = "getDefaultCompetence")
    Competence getCompetenceById(@PathVariable("id") Long id);

    default Competence getDefaultCompetence(Long id, Exception exception)
    {
        Competence skill = new Competence();
        skill.setId(id);
        skill.setNom("Not available");
        return skill;
    }

    default List<Competence> getAllCompetences(Exception exception)
    {
        return List.of();
    }


}
