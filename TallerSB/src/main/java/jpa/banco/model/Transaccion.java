package jpa.banco.model;

import javax.persistence.*;

@Entity
@Table(name = "transacciones")

public class Transaccion {

	@Id
	@Column(name="t_id", unique=true, nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String tId;
	
	@Column(name = "cuenta_id")
	private String cuentaId;
	@Column(name = "t_tipo")
	private String tTipo;
	@Column(name = "t_cantidad")
	private String tCantidad;
	@Column(name = "t_fecha")
	private String tFecha;
	
	public Transaccion() {
		super();
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(String cuentaId) {
		this.cuentaId = cuentaId;
	}

	public String gettTipo() {
		return tTipo;
	}

	public void settTipo(String tTipo) {
		this.tTipo = tTipo;
	}

	public String gettCantidad() {
		return tCantidad;
	}

	public void settCantidad(String tCantidad) {
		this.tCantidad = tCantidad;
	}

	public String gettFecha() {
		return tFecha;
	}

	public void settFecha(String tFecha) {
		this.tFecha = tFecha;
	}
}