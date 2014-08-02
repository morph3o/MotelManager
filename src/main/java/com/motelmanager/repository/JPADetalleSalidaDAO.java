package com.motelmanager.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.motelmanager.domain.DetalleEntrada;
import com.motelmanager.domain.DetalleSalida;
import com.motelmanager.domain.Salida;

@Repository(value = "detalleSalidaDAO")
public class JPADetalleSalidaDAO implements DetalleSalidaDAO {

	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}
	
	@Transactional
	public void ingresarDetalleSalida(DetalleSalida detalleSalida) {
		if(detalleSalida != null) em.persist(detalleSalida);
	}

	@Transactional
	public void modificarDetalleSalida(DetalleSalida detalleSalida) {
		if(detalleSalida != null) em.merge(detalleSalida);
	}

	@Transactional
	public void eliminarDetalleSalida(DetalleSalida detalleSalida) {
		if(detalleSalida != null)
			em.remove(em.contains(detalleSalida) ? detalleSalida : em.merge(detalleSalida));
	}

	@Transactional
	public List<DetalleSalida> listaDetalleSalida(Salida salida) {
		if(salida != null){
			Query q = em.createQuery("select de from DetalleSalida de where de.salida.idSalida = :idSalida");
			q.setParameter("idSalida", salida.getIdSalida());
			return (List<DetalleSalida>)q.getResultList();
		}
		return null;
	}

}
