package jpa.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jpa.banco.model.Cuenta;

public interface ProcedimientoRepository extends JpaRepository<Cuenta, String>{
	
	//call consulta procedure
	@Query(value = "{call consulta(:cuenta)}", nativeQuery = true)
	void consulta(@Param("cuenta") String cuenta_numero);
	
	//call consignacion procedure
	@Query(value = "{call consignacion(:cuenta, :valor)}", nativeQuery = true)
	void consignar(@Param("cuenta") String cuenta_numero, @Param("valor") String cuenta_monto);
	
	//call retiro procedure
	@Query(value = "{call retiro(:cuenta, :valor)}", nativeQuery = true)
	void retirar(@Param("cuenta") String cuenta_numero, @Param("valor") String cuenta_monto);
	
	//call interes procedure
	@Query(value = "{call interes(:cuenta)}", nativeQuery = true)
	void consultarInteres(@Param("cuenta") String cuenta_numero);
}
