package jpa.seleccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidatos")

public class Candidatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DB_id", unique = true, nullable = false)
    private Long dbId;

    @Column(name = "TIPO_DOCUMENTO", nullable = false, length = 2)
    private String tipoDocumento;
    @Column(name = "DOCUMENTO")
    private Integer documento;
    @Column(name = "NOMBRES", nullable = false, length = 50)
    private String nombres;
    @Column(name = "APELLIDOS", nullable = false, length = 50)
    private String apellidos;
    @Column(name = "EDAD", nullable = false)
    private Integer edad;
    @Column(name = "SEXO", nullable = false, length = 5)
    private String sexo;
    @Column(name = "CIUDAD", nullable = false, length = 50)
    private String ciudad;
    @Column(name = "NIVEL_EDUCATIVO", nullable = false, length = 50)
    private String nivelEducativo;
    @Column(name = "PROFESION", nullable = false, length = 50)
    private String profesion;
    @Column(name = "BARRIO", nullable = false, length = 50)
    private String barrio;
    @Column(name = "LOCALIDAD", nullable = false, length = 50)
    private String localidad;
    @Column(name = "ESTRATO", nullable = false)
    private Integer estrato;
    @Column(name = "DATA_CREDITO", nullable = false)
    private Integer dataCredito;

    public Candidatos() {
        super();
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getDocumento() {
        return this.documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNivelEducativo() {
        return this.nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public String getProfesion() {
        return this.profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getBarrio() {
        return this.barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getEstrato() {
        return this.estrato;
    }

    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }

    public Integer getDataCredito() {
        return this.dataCredito;
    }

    public void setDataCredito(Integer dataCredito) {
        this.dataCredito = dataCredito;
    }
}

