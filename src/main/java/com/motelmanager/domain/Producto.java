package com.motelmanager.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="cant_prod")
	private int cantProd;

	private String detalle;

	@Column(name="id_prod")
	private int idProd;

	private String imagen;

	private String marca;

	@Column(name="nm_prod")
	private String nmProd;

	@Column(name="tipo_prod")
	private String tipoProd;

	//bi-directional many-to-one association to DetalleFactura
	@OneToMany(cascade = CascadeType.ALL, mappedBy="producto")
	private List<DetalleFactura> detalleFacturas;

	//bi-directional many-to-one association to Entrada
	@OneToMany(cascade = CascadeType.ALL, mappedBy="producto")
	private List<Entrada> entradas;

	//bi-directional many-to-one association to Salida
	@OneToMany(cascade = CascadeType.ALL, mappedBy="producto")
	private List<Salida> salidas;

	public Producto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCantProd() {
		return this.cantProd;
	}

	public void setCantProd(int cantProd) {
		this.cantProd = cantProd;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getIdProd() {
		return this.idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNmProd() {
		return this.nmProd;
	}

	public void setNmProd(String nmProd) {
		this.nmProd = nmProd;
	}

	public String getTipoProd() {
		return this.tipoProd;
	}

	public void setTipoProd(String tipoProd) {
		this.tipoProd = tipoProd;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	public List<Entrada> getEntradas() {
		return this.entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public List<Salida> getSalidas() {
		return this.salidas;
	}

	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}

}