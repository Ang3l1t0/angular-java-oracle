package jpa.seleccion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jpa.seleccion.model.Candidatos;

@Repository
public interface CandidatosRepository extends JpaRepository<Candidatos, Long> {

}
