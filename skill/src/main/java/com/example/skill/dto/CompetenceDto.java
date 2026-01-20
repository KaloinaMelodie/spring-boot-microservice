package com.example.skill.dto;

import com.example.skill.models.Poste;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompetenceDto {
    private Long id;

    private String nom;

    private List<Poste> postes;
}
