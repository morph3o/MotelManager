package com.motelmanager.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="factura_id_seq",
                       sequenceName="factura_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="factura_id_seq")
	private Integer id;

	@Column(name="id_factura")
	private int idFactura;

	@Column(name="link_imagen")
	private String linkImagen;

	@Column(name="precio_neto")
	private int precioNeto;

	@Column(name="precio_total")
	private int precioTotal;

	//bi-directional many-to-one association to Entrada
	@OneToMany(mappedBy="factura")
	private List<Entrada> entradas;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_prov", referencedColumnName="id_prov")
	private Proveedor proveedor;

	public Factura() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getLinkImagen() {
		return this.linkImagen;
	}

	public void setLinkImagen(String linkImagen) {
		this.linkImagen = linkImagen;
	}

	public int getPrecioNeto() {
		return this.precioNeto;
	}

	public void setPrecioNeto(int precioNeto) {
		this.precioNeto = precioNeto;
	}

	public int getPrecioTotal() {
		return this.precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<Entrada> getEntradas() {
		return this.entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}