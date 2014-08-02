package com.motelmanager.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.motelmanager.domain.DetalleEntrada;
import com.motelmanager.domain.Entrada;
import com.motelmanager.domain.Producto;

@Repository(value = "detalleEntradaDAO")
public class JPADetalleEntradaDAO implements DetalleEntradaDAO {
	
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}

	@Transactional
	public void ingresarDetalleEntrada(DetalleEntrada detalleEntrada) {
		if(detalleEntrada != null) em.persist(detalleEntrada);
	}

	@Transactional
	public void modificarDetalleEntrada(DetalleEntrada detalleEntrada) {
		if(detalleEntrada != null) em.merge(detalleEntrada);
	}

	@Transactional
	public void eliminarDetalleEntrada(DetalleEntrada detalleEntrada) {
		if(detalleEntrada != null)
			em.remove(em.contains(detalleEntrada) ? detalleEntrada : em.merge(detalleEntrada));
	}

	@Transactional
	public List<DetalleEntrada> listaDetalleEntrada(int idEntrada) {
		if(idEntrada >= 0){
			Query q = em.createQuery("select de from DetalleEntrada de where de.entrada.idEntrada = :idEntrada");
			q.setParameter("idEntrada", idEntrada);
			return (List<DetalleEntrada>)q.getResultList();
		}
		return null;
	}

}
