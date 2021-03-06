package jpa.banco.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cliente")

public class Cliente {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "cliente_id", unique=true, nullable=false)
	private Long clienteId;

	@Column(name = "s_id")
	private String sId;
	@Column(name = "cliente_tdocum")
	private String clienteTdocum;
	@Column (name = "cliente_docum")
	private String clienteDocum;
	@Column(name = "cliente_Pnombre")
	private String clientePnombre;
	@Column(name = "cliente_Snombre")
	private String clienteSnombre;
	@Column(name = "cliente_Papellido")
	private String clientePapellido;
	@Column(name = "cliente_Sapellido")
	private String clienteSapellido;
	@Column(name = "cliente_email")
	private String clienteEmail;
	@Column(name = "cliente_ciudad")
	private String clienteCiudad;
	@Column(name = "cliente_calle")
	private String clienteCalle;
	@Column(name = "cliente_numero")
	private String clienteNumero;
	
	
	//Relation one to many between Cliente and Cuenta
	@OneToMany(mappedBy = "clienteId")
	private Set<Cuenta> cuenta;
	
	//Relation many to one between Cliente and Cuenta with s_id
	@ManyToOne
	@JoinColumn(name = "s_id", nullable = false, insertable = false, updatable = false)
	private Sucursal sucursal;
	
	public Cliente() {
		super();
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getClienteTdocum() {
		return clienteTdocum;
	}

	public void setClienteTdocum(String clienteTdocum) {
		this.clienteTdocum = clienteTdocum;
	}

	public String getClienteDocum() {
		return clienteDocum;
	}

	public void setClienteDocum(String clienteDocum) {
		this.clienteDocum = clienteDocum;
	}

	public String getClientePnombre() {
		return clientePnombre;
	}

	public void setClientePnombre(String clientePnombre) {
		this.clientePnombre = clientePnombre;
	}

	public String getClienteSnombre() {
		return clienteSnombre;
	}

	public void setClienteSnombre(String clienteSnombre) {
		this.clienteSnombre = clienteSnombre;
	}

	public String getClientePapellido() {
		return clientePapellido;
	}

	public void setClientePapellido(String clientePapellido) {
		this.clientePapellido = clientePapellido;
	}

	public String getClienteSapellido() {
		return clienteSapellido;
	}

	public void setClienteSapellido(String clienteSapellido) {
		this.clienteSapellido = clienteSapellido;
	}

	public String getClienteEmail() {
		return clienteEmail;
	}

	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}

	public String getClienteCiudad() {
		return clienteCiudad;
	}

	public void setClienteCiudad(String clienteCiudad) {
		this.clienteCiudad = clienteCiudad;
	}

	public String getClienteCalle() {
		return clienteCalle;
	}

	public void setClienteCalle(String clienteCalle) {
		this.clienteCalle = clienteCalle;
	}

	public String getClienteNumero() {
		return clienteNumero;
	}

	public void setClienteNumero(String clienteNumero) {
		this.clienteNumero = clienteNumero;
	}
}