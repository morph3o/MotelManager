package com.motelmanager.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.motelmanager.domain.Entrada;
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
		if(salida != null) em.remove(em.contains(salida) ? salida : em.merge(salida));
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

	@Transactional
	public Salida obtenerSalida(int idSalida) {
		if(idSalida >= 0){
			Query q = em.createQuery("select s from Salida s where s.idSalida = :idSalida");
			q.setParameter("idSalida", idSalida);
			Salida salida = (Salida)q.getSingleResult();
			if(salida != null){
				return salida;
			}
		}
		return null;
	}
}
