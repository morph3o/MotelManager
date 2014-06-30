package com.motelmanager.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.motelmanager.domain.Salida;

@Repository(value = "salidaDAO")
public class JPASalidaDAO implements SalidaDAO{
	
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}
	
	@Transactional
	public void ingresarSalida(Salida salida){
		if(salida != null){			
			em.persist(salida);
		}
	}
	
	@Transactional
	public void eliminarSalida(Salida salida){
		if(salida != null) em.remove(salida);
	}
	
	@Transactional
	public void modificarSalida(Salida salida){
		if(salida != null) em.merge(salida);
	}
	
	@Transactional
	public int obtenerUltimaIDSalida() {
		Query q = em.createQuery ("SELECT MAX(s.idSalida) FROM Salida s");
		Number result = (Number) q.getSingleResult ();
		if(result == null){
			return 0;
		} else {
			return result.intValue();
		}		
	}
}
