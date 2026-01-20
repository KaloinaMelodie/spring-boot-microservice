package com.example.skill.service;

import com.example.skill.dto.CompetenceDto;
import com.example.skill.entities.Competence;
import com.example.skill.mapper.CompetenceMapper;
import com.example.skill.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService implements ICompetenceService{
    private final CompetenceRepository competenceRepository;
    private final CompetenceMapper competenceMapper;

    @Autowired
    public CompetenceService(CompetenceRepository competenceRepository, CompetenceMapper competenceMapper) {
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
    }
    public List<CompetenceDto> getAll(){
        return competenceMapper.CompetenceDtoList(competenceRepository.findAll());
    }

    public CompetenceDto getById(Long id){
        return competenceMapper.CompetenceDto(competenceRepository.findById(id).orElse(null));
    }
}
