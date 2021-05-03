package jpa.banco.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "producto")

public class Producto {

	@Id
	@Column(name="prod_id", unique=true, nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String prodId;
	
	@Column(name = "prod_nombre")
	private String prodNombre;
	@Column(name = "prod_interes")
	private String prodInteres;
	
	public Producto() {
		super();
	}
	
	//Relation one to many between Producto and Cuenta
	@OneToMany(mappedBy = "prodId")
	private Set<Cuenta> cuenta;
	
	//Getters and Setters
	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdNombre() {
		return prodNombre;
	}

	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}

	public String getProdInteres() {
		return prodInteres;
	}

	public void setProdInteres(String prodInteres) {
		this.prodInteres = prodInteres;
	}
}