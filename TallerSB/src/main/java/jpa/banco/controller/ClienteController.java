package jpa.banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.banco.model.Cliente;
import jpa.banco.repository.ClienteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("clientes")

public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getCliente(){
		/*
		 * Returns all clients
		 */
		
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok(clientes);
		
	}
	
	@RequestMapping(value="{clienteID}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("clienteID") Long clienteId){
		/*
		 * Returns clients by Id
		 */
		
		Optional<Cliente> optionalCliente = clienteRepository.findById(clienteId);
		if(optionalCliente.isPresent()) {
			return ResponseEntity.ok(optionalCliente.get());
		}else {
			return ResponseEntity.noContent().build(); //If there are no id number returns no content.
		}
	}
	
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
		/*
		 * Create new client
		 */
		Cliente newCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(newCliente);
	}
	
	@DeleteMapping(value="{clienteID}")
	public ResponseEntity<Void> deleteCliente(@PathVariable("clienteID") Long clienteId){
		/*
		 * Delete Client
		 */
		clienteRepository.deleteById(clienteId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
		Optional<Cliente> optionalCliente = clienteRepository.findById(cliente.getClienteId());
		if(optionalCliente.isPresent()) {
			Cliente updateCliente = optionalCliente.get();
			updateCliente.setClientePnombre(cliente.getClientePnombre());
			updateCliente.setClienteSnombre(cliente.getClienteSnombre());
			updateCliente.setClientePapellido(cliente.getClientePapellido());
			updateCliente.setClienteSapellido(cliente.getClienteSapellido());
			updateCliente.setClienteEmail(cliente.getClienteEmail());
			updateCliente.setClienteNumero(cliente.getClienteNumero());
			updateCliente.setClienteCalle(cliente.getClienteCalle());
			clienteRepository.save(updateCliente);
			return ResponseEntity.ok(updateCliente);
		}else {
			return ResponseEntity.notFound().build(); //If there are no id number returns no content.
		}
	}
}