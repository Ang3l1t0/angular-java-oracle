package jpa.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.banco.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, String>{

}