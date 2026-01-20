package com.example.poste.repository;

import com.example.poste.entities.Poste;
import com.example.poste.models.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteRepository extends JpaRepository<Poste, String> {
    @Query("SELECT p FROM Poste p WHERE :competenceId MEMBER OF p.competencesId")
    List<Poste> getByCompetenceId(Long competenceId);
}
