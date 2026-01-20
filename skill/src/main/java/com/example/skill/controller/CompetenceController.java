package com.example.skill.controller;

import com.example.skill.client.PosteClient;
import com.example.skill.dto.CompetenceDto;
import com.example.skill.entities.Competence;
import com.example.skill.service.CompetenceService;
import com.example.skill.service.ICompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompetenceController {
    private final ICompetenceService competenceService;
    private final PosteClient posteClient;

    @Autowired
    public CompetenceController(ICompetenceService competenceService, PosteClient posteClient) {
        this.competenceService = competenceService;
        this.posteClient = posteClient;
    }

    @GetMapping("/skills")
    public List<CompetenceDto> getAll() {
        List<CompetenceDto> list =  competenceService.getAll();
        list.forEach((competence -> {
            competence.setPostes(posteClient.getPostesCompetence(competence.getId()));
        }));

        return list;
    }

    @GetMapping("/skill/{id}")
    public CompetenceDto getById(@PathVariable("id") Long id) {
        CompetenceDto competence = competenceService.getById(id);
        if (competence == null) {
            return null;
        }
        competence.setPostes(posteClient.getPostesCompetence(id));
        return competence;
    }

}
