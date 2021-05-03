package jpa.banco.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "sucursal")

public class Sucursal {
	
	@Id
	@Column(name="s_id", unique=true, nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String sId;
	
	@Column(name = "s_nombre")
	private String sNombre;
	@Column(name = "s_ciudad")
	private String sCiudad;
	@Column(name = "s_calle")
	private String sCalle;
	
	//Relation one to many between Sucursal and Cuenta
	@OneToMany(mappedBy = "sId")
	private Set<Cuenta> cuenta;
	
	//Relation one to many between Sucursal and Cliente
	@OneToMany(mappedBy = "sId")
	private Set<Cliente> cliente;
	
	public Sucursal() {
		super();
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsCiudad() {
		return sCiudad;
	}

	public void setsCiudad(String sCiudad) {
		this.sCiudad = sCiudad;
	}

	public String getsCalle() {
		return sCalle;
	}

	public void setsCalle(String sCalle) {
		this.sCalle = sCalle;
	}

	
}