package com.motelmanager.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the entradas database table.
 * 
 */
@Entity
@Table(name="entradas")
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="cant_ext_ant")
	private int cantExtAnt;

	@Column(name="cant_ext_desp")
	private int cantExtDesp;

	@Column(name="cant_ingreso")
	private int cantIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="id_entrada")
	private int idEntrada;

	//bi-directional many-to-one association to Factura
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_factura", referencedColumnName="id_factura")
	private Factura factura;

	//bi-directional many-to-one association to Producto
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_prod", referencedColumnName="id_prod")
	private Producto producto;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_persona", referencedColumnName="id_persona")
	private Persona persona;

	public Entrada() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getCantIngreso() {
		return this.cantIngreso;
	}

	public void setCantIngreso(int cantIngreso) {
		this.cantIngreso = cantIngreso;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getIdEntrada() {
		return this.idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
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