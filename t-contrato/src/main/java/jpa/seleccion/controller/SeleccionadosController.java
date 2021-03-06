package jpa.seleccion.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.seleccion.model.Seleccionados;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("candidatos/seleccion")
public class SeleccionadosController {
    
    @Autowired
    private JdbcTemplate jdbc;
    @GetMapping
    public ResponseEntity<List<Seleccionados>> getSeleccionados() {
		
		SqlParameterSource paramIn = new MapSqlParameterSource();
		
		SimpleJdbcCall refCursor = new SimpleJdbcCall(jdbc)
				.withProcedureName("GET_SELECCIONADOS")
				.returningResultSet("RESPONSE",BeanPropertyRowMapper.newInstance(Seleccionados.class));
		try {
			Map<String, Object> getSeleccionados = refCursor.execute(paramIn);
			List<Seleccionados> seleccionados = (List<Seleccionados>) getSeleccionados.get("RESPONSE");
			return new ResponseEntity<List<Seleccionados>>(seleccionados,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}