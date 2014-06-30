package com.motelmanager.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.motelmanager.domain.Factura;

@Repository(value = "facturaDAO")
public class JPAFacturaDAO implements FacturaDAO{
	
private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}

	@Override
	@Transactional
	public void ingresarFactura(Factura factura) {		
		if(factura != null){
			if(this.obtenerFactura(factura.getIdFactura()) == null){
				em.persist(factura);
			}else{
				System.out.println("Factura duplicada");
			}
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Factura obtenerFactura(int idFactura) {		
		return (Factura) em.createQuery("select f from Factura f where f.idFactura = :id")
				.setParameter("id", idFactura)
				.getSingleResult();
	}

	@Override
	@Transactional
	public void modificarFactura(int idFactura, Factura nuevaFactura) {		
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Factura> obtenerFacturas() {		
		return em.createQuery("select f from Factura f order by f.id").getResultList();
	}

}
