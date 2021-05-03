package jpa.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.banco.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{

}