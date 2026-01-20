package com.example.poste.dto;

import com.example.poste.models.Competence;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PosteDto {
    private String id;
    private String poste;
    private List<Long> competencesId;
    private List<Competence> competences;
}
