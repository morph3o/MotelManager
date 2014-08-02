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
	@SequenceGenerator(name="producto_id_seq",
                       sequenceName="producto_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="producto_id_seq")
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
	@OneToMany(mappedBy="producto")
	private List<DetalleFactura> detalleFacturas;

	//bi-directional many-to-one association to DetalleEntrada
	@OneToMany(mappedBy="producto")
	private List<DetalleEntrada> detalleEntradas;

	//bi-directional many-to-one association to DetalleSalida
	@OneToMany(mappedBy="producto")
	private List<DetalleSalida> detalleSalidas;

	public Producto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public List<DetalleEntrada> getDetalleEntradas() {
		return detalleEntradas;
	}

	public void setDetalleEntradas(List<DetalleEntrada> detalleEntradas) {
		this.detalleEntradas = detalleEntradas;
	}

	public List<DetalleSalida> getDetalleSalidas() {
		return detalleSalidas;
	}

	public void setDetalleSalidas(List<DetalleSalida> detalleSalidas) {
		this.detalleSalidas = detalleSalidas;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}