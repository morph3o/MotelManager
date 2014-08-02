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
@Table(name="detalle_salida")
public class DetalleSalida implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="detalle_salida_id_seq", sequenceName="detalle_salida_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="detalle_salida_id_seq")
	private Integer id;
	
	@Column(name="cant_ext_ant")
	private Integer cantExtAnt;

	@Column(name="cant_ext_desp")
	private Integer cantExtDesp;

	@Column(name="cant_salida")
	private Integer cantSalida;

	//bi-directional many-to-one association to Producto
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_prod", referencedColumnName="id_prod")
	private Producto producto;

	//bi-directional many-to-one association to Salida
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_salida", referencedColumnName="id_salida")
	private Salida salida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantExtAnt() {
		return cantExtAnt;
	}

	public void setCantExtAnt(Integer cantExtAnt) {
		this.cantExtAnt = cantExtAnt;
	}

	public Integer getCantExtDesp() {
		return cantExtDesp;
	}

	public void setCantExtDesp(Integer cantExtDesp) {
		this.cantExtDesp = cantExtDesp;
	}

	public Integer getCantSalida() {
		return cantSalida;
	}

	public void setCantSalida(Integer cantSalida) {
		this.cantSalida = cantSalida;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Salida getSalida() {
		return salida;
	}

	public void setSalida(Salida salida) {
		this.salida = salida;
	}

}
