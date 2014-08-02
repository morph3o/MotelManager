package com.motelmanager.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="detalle_entrada")
public class DetalleEntrada implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="detalle_entrada_id_seq",
                       sequenceName="detalle_entrada_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="detalle_entrada_id_seq")
	private Integer id;
	
	@Column(name="cant_ext_ant")
	private int cantExtAnt;

	@Column(name="cant_ext_desp")
	private int cantExtDesp;

	@Column(name="cant_ingreso")
	private int cantIngreso;

	//bi-directional many-to-one association to Entrada
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_entrada", referencedColumnName="id_entrada")
	private Entrada entrada;

	//bi-directional many-to-one association to Producto
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_prod", referencedColumnName="id_prod")
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantExtAnt() {
		return cantExtAnt;
	}

	public void setCantExtAnt(int cantExtAnt) {
		this.cantExtAnt = cantExtAnt;
	}

	public int getCantExtDesp() {
		return cantExtDesp;
	}

	public void setCantExtDesp(int cantExtDesp) {
		this.cantExtDesp = cantExtDesp;
	}

	public int getCantIngreso() {
		return cantIngreso;
	}

	public void setCantIngreso(int cantIngreso) {
		this.cantIngreso = cantIngreso;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
