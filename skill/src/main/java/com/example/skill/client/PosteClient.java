package com.example.skill.client;

import com.example.skill.models.Poste;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "POSTE")
public interface PosteClient {

    @GetMapping("/postesbycompetence/{id}")
    @CircuitBreaker(name = "postes", fallbackMethod = "getDefaultPostesCompetence")
    List<Poste> getPostesCompetence(@PathVariable("id") Long id);

    default List<Poste> getDefaultPostesCompetence(Long id, Exception exception)
    {
        return List.of();
    }
}
