package com.motelmanager.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="persona_id_seq",
                       sequenceName="persona_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="persona_id_seq")
	private Integer id;

	@Column(name="ape_materno")
	private String apeMaterno;

	@Column(name="ape_paterno")
	private String apePaterno;

	private String email;

	@Column(name="id_persona")
	private String idPersona;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Entrada
	@OneToMany(mappedBy="persona")
	private List<Entrada> entrada;

	//bi-directional many-to-one association to Salida
	@OneToMany(mappedBy="persona")
	private List<Salida> salida;

	public Persona() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApeMaterno() {
		return this.apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return this.apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Entrada> getEntradas() {
		return this.entrada;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entrada = entradas;
	}

	public List<Salida> getSalidas() {
		return this.salida;
	}

	public void setSalidas(List<Salida> salidas) {
		this.salida = salidas;
	}

}