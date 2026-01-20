package com.example.skill.entities;

import com.example.skill.models.Poste;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Transient
    private List<Poste> postes;

    public Competence(String nom) {
        this.nom = nom;
    }
}
