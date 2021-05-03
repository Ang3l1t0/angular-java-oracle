package jpa.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.banco.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, String>{

}