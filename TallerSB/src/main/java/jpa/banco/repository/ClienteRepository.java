package jpa.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.banco.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}