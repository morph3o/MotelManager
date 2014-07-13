package com.motelmanager.service;

import java.io.Serializable;
import java.util.List;

import com.motelmanager.domain.Producto;

public interface ProductManager extends Serializable{
	
	public void addProduct(Producto product);
	
	public Producto getProduct(int idProd);
	
	public void guardarProducto(Producto producto);
	
	public List<Producto> listarProductos();
	
	public void eliminarProducto(Producto prod);
	
	public void updateProducto(Producto prod);

}
