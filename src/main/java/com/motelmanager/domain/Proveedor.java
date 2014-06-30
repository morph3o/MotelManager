package com.motelmanager.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="dir_prov")
	private String dirProv;

	@Column(name="email_prov")
	private String emailProv;

	@Column(name="id_prov")
	private String idProv;

	@Column(name="nm_prov")
	private String nmProv;

	@Column(name="tel_prov")
	private String telProv;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="proveedor")
	private List<Factura> facturas;

	public Proveedor() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDirProv() {
		return this.dirProv;
	}

	public void setDirProv(String dirProv) {
		this.dirProv = dirProv;
	}

	public String getEmailProv() {
		return this.emailProv;
	}

	public void setEmailProv(String emailProv) {
		this.emailProv = emailProv;
	}

	public String getIdProv() {
		return this.idProv;
	}

	public void setIdProv(String idProv) {
		this.idProv = idProv;
	}

	public String getNmProv() {
		return this.nmProv;
	}

	public void setNmProv(String nmProv) {
		this.nmProv = nmProv;
	}

	public String getTelProv() {
		return this.telProv;
	}

	public void setTelProv(String telProv) {
		this.telProv = telProv;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

}