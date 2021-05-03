package jpa.seleccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.seleccion.model.Scores;

public interface ScoresRepository extends JpaRepository<Scores, Long> {
    
}
