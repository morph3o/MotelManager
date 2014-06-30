package com.motelmanager.web.bean.inventario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.motelmanager.domain.Entrada;
import com.motelmanager.domain.Producto;
import com.motelmanager.service.ProductManager;
import com.motelmanager.util.FacesMessageUtil;

@Controller("inventarioBean")
public class InventarioManageBean{
	
	@Autowired
	private ProductManager productoManager;
	
	private Producto producto;
	
	private List<Producto> productos;
	
	private List<Entrada> entradas;
	
	public void iniciarProducto(){
		this.producto = new Producto();
	}
	
	public void obtenerProductos(){
		this.productos = productoManager.listarProductos();
	}

	public void insertarProducto(Producto producto){
		try{
			productoManager.guardarProducto(producto);
			FacesMessageUtil.showInfoMessage("El producto fue ingresado exitosamente.");
		}catch(Exception ex){
			FacesMessageUtil.showErrorMessage(ex.getMessage());
		}
	}
	
	public void setProductoManager(ProductManager productoManager){
		this.productoManager = productoManager;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}
	
}
