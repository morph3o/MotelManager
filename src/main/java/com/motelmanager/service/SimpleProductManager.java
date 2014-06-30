package com.motelmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motelmanager.domain.Producto;
import com.motelmanager.repository.ProductoDAO;

@Service("productoManager")
public class SimpleProductManager implements ProductManager {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductoDAO productoDAO;
	
	private List<Producto> products;
	
	public void setProductDAO(ProductoDAO prod){
		this.productoDAO = prod;
	}

	@Override
	public void addProduct(Producto product) {
		if(product != null) products.add(product);
	}

	@Override
	public Producto getProduct(int idProd) {
		this.products = productoDAO.getProductos();
		for(Producto prod : products){
			if(prod.getIdProd() == idProd){
				return prod;
			}
		}
		return null;
	}
	
	public void setProducts(List<Producto> products){
		this.products = products;
	}
	
	@Override
	public void guardarProducto(Producto producto) {
		productoDAO.saveProducto(producto);
	}

	@Override
	public List<Producto> listarProductos() {
		return productoDAO.getProductos();
	}

}
