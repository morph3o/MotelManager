package com.motelmanager.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.motelmanager.domain.Producto;

@Repository(value = "productoDAO")
public class JPAProductoDAO implements ProductoDAO{
	
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Producto> getProductos() {
		return em.createQuery("select p from Producto p order by p.id").getResultList();
	}

	@Transactional
	public void saveProducto(Producto prod) {
		if(prod != null) em.persist(prod);
	}

	@Transactional(readOnly = true)
	public Producto obtenerProducto(int idProducto) {
		Producto prod = null;
		try{
			prod = (Producto) em.createQuery("select p from Producto p where p.idProd = :idProducto")
					.setParameter("idProducto", idProducto)
					.getSingleResult();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return prod;
	}

	@Transactional
	public void modificarProducto(Producto producto) {
		if(producto != null){
			em.merge(producto);
		} 
	}

	@Transactional(readOnly = true)
	public boolean existeProducto(Producto producto) {
		try{
			if(producto != null){
				if(this.obtenerProducto(producto.getIdProd()) != null){
					return true;
				}
			}			
		}catch(NoResultException ex){
			return false;
		}catch(NonUniqueResultException ex){
			return true;
		}
		return false;
	}

	@Transactional
	public void removerProducto(Producto prod) {
		em.remove(em.contains(prod) ? prod : em.merge(prod));
	}
	
	

}
