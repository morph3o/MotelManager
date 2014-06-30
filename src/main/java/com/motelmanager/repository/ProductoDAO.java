package com.motelmanager.repository;

import java.util.List;

import com.motelmanager.domain.Producto;

public interface ProductoDAO {

	public List<Producto> getProductos();	
	public void saveProducto(Producto prod);
	public Producto obtenerProducto(int idProducto);
	public void modificarProducto(Producto producto);
	public boolean existeProducto(Producto producto);
	public void removerProducto(Producto prod);

}
