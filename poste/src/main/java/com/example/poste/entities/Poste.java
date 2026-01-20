package com.example.poste.entities;

import com.example.poste.models.Competence;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Poste {

    @Id
    private String id;
    @Column()
    private String poste;
    @ElementCollection
    private List<Long> competencesId;
    @Transient
    private List<Competence> competences;

}
