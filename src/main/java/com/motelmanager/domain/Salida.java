package com.motelmanager.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the salidas database table.
 * 
 */
@Entity
@Table(name="salidas")
public class Salida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="cant_egreso")
	private int cantEgreso;

	@Column(name="cant_ext_ant")
	private int cantExtAnt;

	@Column(name="cant_ext_desp")
	private int cantExtDesp;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_egreso")
	private Date fechaEgreso;

	@Column(name="id_salida")
	private int idSalida;

	//bi-directional many-to-one association to Producto
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_prod", referencedColumnName="id_prod")
	private Producto producto;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_persona", referencedColumnName="id_persona")
	private Persona persona;

	public Salida() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCantEgreso() {
		return this.cantEgreso;
	}

	public void setCantEgreso(int cantEgreso) {
		this.cantEgreso = cantEgreso;
	}

	public int getCantExtAnt() {
		return this.cantExtAnt;
	}

	public void setCantExtAnt(int cantExtAnt) {
		this.cantExtAnt = cantExtAnt;
	}

	public int getCantExtDesp() {
		return this.cantExtDesp;
	}

	public void setCantExtDesp(int cantExtDesp) {
		this.cantExtDesp = cantExtDesp;
	}

	public Date getFechaEgreso() {
		return this.fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public int getIdSalida() {
		return this.idSalida;
	}

	public void setIdSalida(int idSalida) {
		this.idSalida = idSalida;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}