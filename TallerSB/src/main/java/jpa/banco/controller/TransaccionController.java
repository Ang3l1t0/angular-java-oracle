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

import jpa.banco.model.Transaccion;
import jpa.banco.repository.TransaccionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("transacciones")

public class TransaccionController {

	@Autowired
	private TransaccionRepository transaccionRepository;
	
	@GetMapping	
	public ResponseEntity<List<Transaccion>> getTransaccion(){
		/*
		 * Returns all transactions
		 */
		List<Transaccion> transacciones = transaccionRepository.findAll();
		return ResponseEntity.ok(transacciones);
	}
	
	@RequestMapping(value="{tId}")
	public ResponseEntity<Transaccion> getTransaccionById(@PathVariable("tId") String tId){
		/*
		 * Returns transactions by Id
		 */
		
		Optional<Transaccion> optionalTransaccion = transaccionRepository.findById(tId);
		if(optionalTransaccion.isPresent()) {
			return ResponseEntity.ok(optionalTransaccion.get());
		}else {
			return ResponseEntity.noContent().build(); //If there are no id number returns no content.
		}
	}
}