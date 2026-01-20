package com.example.poste.controller;

import com.example.poste.client.CompetenceClient;
import com.example.poste.dto.PosteDto;
import com.example.poste.entities.Poste;
import com.example.poste.models.Competence;
import com.example.poste.service.IPosteService;
import com.example.poste.service.PosteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PosteController {
    private final IPosteService posteService;

    private final CompetenceClient competenceClient;

    public PosteController(IPosteService posteService, CompetenceClient competenceClient) {
        this.posteService = posteService;
        this.competenceClient = competenceClient;
    }

    @GetMapping("/postes")
    public List<PosteDto> getAll() {
        List<PosteDto> list = posteService.getAll();
        list.forEach((poste -> {
            List<Competence> comps = new ArrayList<>();
            poste.getCompetencesId().forEach(competenceId -> {
                Competence competence = competenceClient.getCompetenceById(competenceId);
                comps.add(competence);
            });
            poste.setCompetences(comps);
        }));
        return list;
    }

    @GetMapping("/poste/{id}")
    public PosteDto getById(@PathVariable String id) {
        PosteDto poste = posteService.getById(id);
        List<Competence> comps = new ArrayList<>();
        poste.getCompetencesId().forEach(competenceId -> {
            Competence competence = competenceClient.getCompetenceById(competenceId);
            comps.add(competence);
        });
        poste.setCompetences(comps);

        return poste;
    }

    @GetMapping("/postesbycompetence/{id}")
    public List<PosteDto> getPostesCompetence(@PathVariable("id") Long id){
        return posteService.findByCompetenceId(id);
}
}
