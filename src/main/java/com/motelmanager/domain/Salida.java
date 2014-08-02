package com.motelmanager.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the salidas database table.
 * 
 */
@Entity
@Table(name="salida")
public class Salida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="salida_id_seq",
                       sequenceName="salida_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="salida_id_seq")
	private Integer id;

	@Column(name="cant_prod_sac")
	private int cantProdSac;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_egreso")
	private Date fechaEgreso;

	@Column(name="id_salida")
	private int idSalida;
	
	//bi-directional many-to-one association to DetalleSalida
	@OneToMany(mappedBy="salida")
	private List<DetalleSalida> detalleSalidas;

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

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getCantProdSac() {
		return cantProdSac;
	}

	public void setCantProdSac(int cantProdSac) {
		this.cantProdSac = cantProdSac;
	}

	public List<DetalleSalida> getDetalleSalidas() {
		return detalleSalidas;
	}

	public void setDetalleSalidas(List<DetalleSalida> detalleSalidas) {
		this.detalleSalidas = detalleSalidas;
	}

}