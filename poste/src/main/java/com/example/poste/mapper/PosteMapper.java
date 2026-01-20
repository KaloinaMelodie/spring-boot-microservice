package com.example.poste.mapper;

import com.example.poste.dto.PosteDto;
import com.example.poste.entities.Poste;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PosteMapper {
    public Poste Poste(PosteDto posteDto) {
        return new Poste(posteDto.getId(),posteDto.getPoste(), posteDto.getCompetencesId(),posteDto.getCompetences());
    }

    public PosteDto PosteDto(Poste poste) {
        return new PosteDto(poste.getId(),poste.getPoste(), poste.getCompetencesId(),poste.getCompetences());
    }

    public List<PosteDto> PosteDtoList(List<Poste> postes) {
        return postes.stream().map(this::PosteDto).collect(Collectors.toList());
    }
}
