package com.motelmanager.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.motelmanager.domain.Entrada;

@Repository(value = "entradaDAO")
public class JPAEntradaDAO implements EntradaDAO{

	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}
		
	@Transactional
	public void ingresoProductos(Entrada entrada){
		if(entrada != null){			
			em.persist(entrada);
		}
	}
	
	@Transactional
	public void eliminarEntrada(Entrada entrada){
		if(entrada != null) em.remove(entrada);
	}
	
	@Transactional
	public void modificarEntrada(Entrada entrada){
		if(entrada != null) em.merge(entrada);
	}

	@Transactional
	public int obtenerUltimaIDEntrada() {
		Query q = em.createQuery ("SELECT MAX(e.idEntrada) FROM Entrada e");
		Number result = (Number) q.getSingleResult ();
		if(result == null){
			return 0;
		} else {
			return result.intValue();
		}		
	}

}
