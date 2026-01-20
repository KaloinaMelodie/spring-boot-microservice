package com.example.skill.service;


import com.example.skill.dto.CompetenceDto;
import com.example.skill.entities.Competence;

import java.util.List;

public interface ICompetenceService {
    public List<CompetenceDto> getAll();
    public CompetenceDto getById(Long id);
}
