package jpa.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.banco.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, String>{

}