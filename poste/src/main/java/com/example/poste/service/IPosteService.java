package com.example.poste.service;

import com.example.poste.dto.PosteDto;
import com.example.poste.entities.Poste;

import java.util.List;

public interface IPosteService {
    public List<PosteDto> getAll();
    public PosteDto getById(String id);
    public List<PosteDto> findByCompetenceId(Long id);
}
