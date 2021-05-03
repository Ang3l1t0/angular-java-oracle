package jpa.banco.model;

import javax.persistence.*;

@Entity
@Table(name = "cuenta")

public class Cuenta {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cuenta_id", unique=true, nullable=false)
	private String cuentaId;
	
	@Column(name = "cliente_id")
	private String clienteId;
	@Column(name = "s_id")
	private String sId;
	@Column(name = "prod_id")
	private String prodId;
	@Column(name = "cuenta_numero")
	private String cuentaNumero;
	@Column(name = "cuenta_estado")
	private String cuentaEstado;
	@Column(name = "cuenta_monto")
	private String cuentaMonto;
	@Column(name = "cuenta_tipo")
	private String cuentaTipo;
	@Column(name = "cuenta_fecha")
	private String cuentaFecha;
	
	// Relationships 
	//Relation many to one between Cuenta and Cliente with cliente_id
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false, insertable = false, updatable = false)
	private Cliente cliente;
	
	//Relation many to one between Cuenta and Sucursal with s_id
	@ManyToOne
	@JoinColumn(name = "s_id", nullable = false, insertable = false, updatable = false)
	private Sucursal sucursal;
	
	//Relation many to one between Cuenta and Producto with s_id
	@ManyToOne
	@JoinColumn(name = "prod_id", nullable = false, insertable = false, updatable = false)
	private Producto producto;
	
	public Cuenta() {
		super();
	}
	
	//Getters and Setters
	public String getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(String cuentaId) {
		this.cuentaId = cuentaId;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getCuentaNumero() {
		return cuentaNumero;
	}

	public void setCuentaNumero(String cuentaNumero) {
		this.cuentaNumero = cuentaNumero;
	}

	public String getCuentaEstado() {
		return cuentaEstado;
	}

	public void setCuentaEstado(String cuentaEstado) {
		this.cuentaEstado = cuentaEstado;
	}

	public String getCuentaMonto() {
		return cuentaMonto;
	}

	public void setCuentaMonto(String cuentaMonto) {
		this.cuentaMonto = cuentaMonto;
	}

	public String getCuentaTipo() {
		return cuentaTipo;
	}

	public void setCuentaTipo(String cuentaTipo) {
		this.cuentaTipo = cuentaTipo;
	}

	public String getCuentaFecha() {
		return cuentaFecha;
	}

	public void setCuentaFecha(String cuentaFecha) {
		this.cuentaFecha = cuentaFecha;
	}
}