package com.motelmanager.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.motelmanager.domain.Persona;

@Repository(value = "personaDAO")
public class JPAPersonaDAO implements PersonaDAO{
	
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}

	@Override
	public Persona obtenerPersonaPorNombreUsuario(String nombreUsuario)
			throws Exception {
		if(nombreUsuario != null && !nombreUsuario.isEmpty()){
			Query q = em.createQuery("SELECT p FROM Persona p WHERE p.nombreUsuario LIKE :nombreUsuario");
			q.setParameter("nombreUsuario", nombreUsuario);
			//Persona persona = new Persona((Persona)q.getSingleResult());
			Persona persona = null;
			if(persona != null){
				return persona;
			}
		}
		return null;
	}

	@Override
	public void guardarPersona(Persona persona) throws Exception {
		if(persona != null){
			em.persist(persona);
		}
	}

	@Override
	public Persona updatePersona(Persona persona) throws Exception {
		if(persona != null) em.merge(persona);
		return persona;
	}

}
