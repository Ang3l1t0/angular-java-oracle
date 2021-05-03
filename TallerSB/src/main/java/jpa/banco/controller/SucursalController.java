package jpa.banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.banco.model.Sucursal;
import jpa.banco.repository.SucursalRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("sucursales")

public class SucursalController {
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	@GetMapping
	public ResponseEntity<List<Sucursal>> getSucursal(){
		
		List<Sucursal> sucursales = sucursalRepository.findAll();
		return ResponseEntity.ok(sucursales);
		
	}
	
	@RequestMapping(value="{sId}")
	public ResponseEntity<Sucursal> getSucursalById(@PathVariable("sId") String sId){
		/*
		 * Returns clients by sucursal id
		 */
		
		Optional<Sucursal> optionalSucursal = sucursalRepository.findById(sId);
		if(optionalSucursal.isPresent()) {
			return ResponseEntity.ok(optionalSucursal.get());
		}else {
			return ResponseEntity.noContent().build(); //If there are no sucursal id number returns no content.
		}
	}
}