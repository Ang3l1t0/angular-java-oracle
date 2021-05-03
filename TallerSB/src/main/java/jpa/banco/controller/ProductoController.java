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

import jpa.banco.model.Producto;
import jpa.banco.repository.ProductoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("productos")

public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping
	public ResponseEntity<List<Producto>> getProducto(){
		/*
		 * Returns all Product (account type)
		 */
		List<Producto> productos = productoRepository.findAll();
		return ResponseEntity.ok(productos);
	}
	
	@RequestMapping(value="{prodId}")
	public ResponseEntity<Producto> getProductoById(@PathVariable("prodId") String prodId){
		/*
		 * Returns product by id
		 */
		
		Optional<Producto> optionalProducto = productoRepository.findById(prodId);
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		}else {
			return ResponseEntity.noContent().build(); //If there are no id number returns no content
		}
	}
}