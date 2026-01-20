package com.example.skill.mapper;

import com.example.skill.dto.CompetenceDto;
import com.example.skill.entities.Competence;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompetenceMapper {
    public Competence Competence(CompetenceDto competenceDto) {
        return new Competence(competenceDto.getId(),competenceDto.getNom(),competenceDto.getPostes());
    }

    public CompetenceDto CompetenceDto(Competence competence) {
        return new CompetenceDto(competence.getId(),competence.getNom(),competence.getPostes());
    }

    public List<CompetenceDto> CompetenceDtoList(List<Competence> competences) {
        return competences.stream().map(this::CompetenceDto).collect(Collectors.toList());
    }
}
