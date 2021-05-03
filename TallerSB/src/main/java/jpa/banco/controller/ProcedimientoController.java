package jpa.banco.controller;

import org.springframework.web.bind.annotation.*;

import jpa.banco.repository.ProcedimientoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ProcedimientoController {

	private final ProcedimientoRepository procedimientoRepository;
	
	public ProcedimientoController(ProcedimientoRepository procedimientoRepository) {
		this.procedimientoRepository = procedimientoRepository;
	}
	
	//Consulta cuenta
	@GetMapping(value="cuentas/consulta")
	public void saldoCuenta(@RequestParam("cuenta") String cuentaNumero) {
		try {
			
			procedimientoRepository.consulta(cuentaNumero);
			
		} catch(NegativeArraySizeException e) {
			
		}
	}
	
	//Consignación
	@GetMapping(value="cuentas/consignacion")
	public void consignar(@RequestParam("cuenta") String cuentaNumero, @RequestParam("valor") String valorConsignar) {
		try {
			
			procedimientoRepository.consignar(cuentaNumero, valorConsignar);
			
		} catch(NegativeArraySizeException e) {
			
		}
	}
	
	//Retiro
	@GetMapping(value="cuentas/retiro")
	public void retirar(@RequestParam("cuenta") String cuentaNumero, @RequestParam("valor") String valorConsignar) {
		try {
			
			procedimientoRepository.retirar(cuentaNumero, valorConsignar);
			
		} catch(NegativeArraySizeException e) {
			
		}
	}
	
	//Interes
	@GetMapping(value="cuentas/interes")
	public void consultarInteres(@RequestParam("cuenta") String cuentaNumero) {
		try {
			
			procedimientoRepository.consultarInteres(cuentaNumero);
			
		} catch(NegativeArraySizeException e) {
			
		}
	}
}