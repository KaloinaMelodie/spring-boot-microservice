package com.example.poste.service;

import com.example.poste.dto.PosteDto;
import com.example.poste.entities.Poste;
import com.example.poste.mapper.PosteMapper;
import com.example.poste.models.Competence;
import com.example.poste.repository.PosteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PosteService implements IPosteService {
    private final PosteRepository posteRepository;
    private final PosteMapper posteMapper;

    public PosteService(PosteRepository posteRepository, PosteMapper posteMapper) {
        this.posteRepository = posteRepository;
        this.posteMapper = posteMapper;
    }

    public List<PosteDto> getAll(){
        return posteMapper.PosteDtoList(posteRepository.findAll());
    }

    public PosteDto getById(String id){
        return posteMapper.PosteDto(posteRepository.findById(id).orElse(null));
    }


    public List<PosteDto> findByCompetenceId(Long id) {
        return posteMapper.PosteDtoList(posteRepository.getByCompetenceId(id));
    }
}
