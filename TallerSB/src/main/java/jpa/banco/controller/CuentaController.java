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

import jpa.banco.model.Cuenta;
import jpa.banco.repository.CuentaRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("cuentas")

public class CuentaController {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@GetMapping
	public ResponseEntity<List<Cuenta>> getCuenta(){
		/*
		 * Returns all accounts
		 */
		
		List<Cuenta> cuentas = cuentaRepository.findAll();
		return ResponseEntity.ok(cuentas);
	}
	
	@RequestMapping(value="{cuentaID}")
	public ResponseEntity<Cuenta> getCuentaById(@PathVariable("cuentaID") String cuentaId){
		/*
		 * Returns accounts by id
		 */
		
		Optional<Cuenta> optionalCuenta = cuentaRepository.findById(cuentaId);
		if(optionalCuenta.isPresent()) {
			return ResponseEntity.ok(optionalCuenta.get());
		}else {
			return ResponseEntity.noContent().build(); // If there are no account id number returns no content.
		}
	}
}