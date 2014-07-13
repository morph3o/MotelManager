package com.motelmanager.web.bean.inventario;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

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
	private Producto productoMod;
	
	private List<Producto> productos;
	
	private List<Entrada> entradas;

	private String idProdEliminar;
	
	public void iniciarProducto(){
		this.producto = new Producto();
	}
	
	public void iniciarProductoMod(){
		this.productoMod = new Producto();
	}
	
	public void obtenerProductos(){
		this.productos = productoManager.listarProductos();
	}

	public void insertarProducto(){
		try{
			productoManager.guardarProducto(this.producto);
			obtenerProductos();
			FacesMessageUtil.showInfoMessage("El producto "+this.producto.getNmProd()+" fue ingresado exitosamente.");
		}catch(Exception ex){
			ex.printStackTrace();
			FacesMessageUtil.showErrorMessage("Ocurrió un error al ingresar el producto.");
		} finally {
			iniciarProducto();
		}
	}
	
	public void eliminarProducto(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap(); 
		idProdEliminar = params.get("idProd");
		int idProd = Integer.parseInt(idProdEliminar);
		for(Producto prod : this.productos){
			if(prod.getIdProd() == idProd){
				productoManager.eliminarProducto(prod);
				this.productos.remove(prod);
				break;
			}
		}
	}
	
	public void cargarModalModificarProducto(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap(); 
		idProdEliminar = params.get("idProd");
		int idProd = Integer.parseInt(idProdEliminar);
		for(Producto prod : this.productos){
			if(prod.getIdProd() == idProd){
				this.productoMod = prod;
				break;
			}
		}
	}
	
	public void modificarProducto(){
		productoManager.updateProducto(productoMod);
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

	public Producto getProductoMod() {
		return productoMod;
	}

	public void setProductoMod(Producto productoMod) {
		this.productoMod = productoMod;
	}
	
}
