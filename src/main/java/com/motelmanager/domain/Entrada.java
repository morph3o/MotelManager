package com.motelmanager.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the entradas database table.
 * 
 */
@Entity
@Table(name="entrada")
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entrada_id_seq",
                       sequenceName="entrada_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="entrada_id_seq")
	private Integer id;
	
	@Column(name="cant_prod_ing")
	private int cantProdIng;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="id_entrada")
	private int idEntrada;
	
	//bi-directional many-to-one association to DetalleEntrada
	@OneToMany(mappedBy="entrada")
	private List<DetalleEntrada> detalleEntradas;

	//bi-directional many-to-one association to Factura
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_factura", referencedColumnName="id_factura")
	private Factura factura;

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

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getCantProdIng() {
		return cantProdIng;
	}

	public void setCantProdIng(int cantProdIng) {
		this.cantProdIng = cantProdIng;
	}

	public List<DetalleEntrada> getDetalleEntradas() {
		return detalleEntradas;
	}

	public void setDetalleEntradas(List<DetalleEntrada> detalleEntradas) {
		this.detalleEntradas = detalleEntradas;
	}

}