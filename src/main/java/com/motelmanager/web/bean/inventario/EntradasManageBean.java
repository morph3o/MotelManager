package com.motelmanager.web.bean.inventario;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.motelmanager.domain.Entrada;
import com.motelmanager.domain.Producto;
import com.motelmanager.service.EntradaManager;
import com.motelmanager.service.ProductManager;
import com.motelmanager.util.FacesMessageUtil;

@Controller("entradasBean")
public class EntradasManageBean {
	
	@Autowired
	private ProductManager productoManager;
	
	@Autowired
	private EntradaManager entradaManager;

	private Entrada entrada;
	private int idEntrada;
	private List<Entrada> listaEntradas;
	private List<Producto> listaProductosEntrada;
	private Date fechaIngreso;
	private Entrada entradaBorrar;
	
	/** 
	 *  Valores asociados al modal para
	 *  agregar productos a la lista 
	 */
	private Map<String,String> listaProductos;
	private Producto productoNuevo;
	private String prodSelec;
	private int cantidadIngreso;
	
	public void init(){
		this.listaProductos = new HashMap<String,String>();
		List<Producto> listaProdAux = productoManager.listarProductos();
		for(Producto prod : listaProdAux){
			this.listaProductos.put(prod.getNmProd(), prod.getNmProd());
		}
		this.setIdEntrada(entradaManager.obtenerUltimaIDEntrada()+1);
		this.initParameters(null);
	}
	
	public void ingresarListaProductos(){
		
	}
	
	public void initParameters(ActionEvent actionEvent){
		this.entrada = new Entrada();
		this.listaEntradas = new ArrayList<Entrada>();
		if(this.listaProductosEntrada == null) listaProductosEntrada = new ArrayList<Producto>();
		this.fechaIngreso = null;
		this.cantidadIngreso = 0;
	}
	
	public void limpiarModalNuevoProducto(){
		this.cantidadIngreso = 0;
		this.productoNuevo = null;
	}
	
	public void cargarProductoALista(ActionEvent actionEvent){
		Entrada entrada = new Entrada();
		Producto auxProd = null;
		for(Producto prod : productoManager.listarProductos()){
			if(prod.getNmProd().equalsIgnoreCase(prodSelec)){
				auxProd = prod;
			}
		}
		if(auxProd == null){
			FacesMessageUtil.showErrorMessage("Debes seleccionar un producto de la lista.");
			return;
		} else if (this.cantidadIngreso == 0){
			FacesMessageUtil.showErrorMessage("La cantidad ingresada debe ser mayor a 0.");
			return;
		} else if(this.existeProdEnEntradas(auxProd)){
			for(Entrada entradaAux : this.listaEntradas){
				if(entradaAux.getProducto().getIdProd() == auxProd.getIdProd()){
					entradaAux.setCantIngreso(entradaAux.getCantIngreso() + this.cantidadIngreso);
					entradaAux.setCantExtDesp(entradaAux.getCantExtDesp() + this.cantidadIngreso);
					this.limpiarModalNuevoProducto();
					return;
				}			
			}
		} else {
			int cantFutura = 0;
			entrada.setIdEntrada(this.idEntrada);
			entrada.setFactura(null);
			entrada.setProducto(auxProd);			
			entrada.setCantIngreso(this.cantidadIngreso);
			entrada.setCantExtAnt(auxProd.getCantProd());
			cantFutura = auxProd.getCantProd() + this.cantidadIngreso;
			entrada.setCantExtDesp(cantFutura);
			entrada.getProducto().setCantProd(cantFutura);
			
			this.listaEntradas.add(entrada);
			this.limpiarModalNuevoProducto();
		}		
	}
	
	private boolean existeProdEnEntradas(Producto producto){
		for(Entrada entrada : this.listaEntradas){
			if(entrada.getProducto().getIdProd() == producto.getIdProd()){
				return true;
			}
		}
		return false;
	}
	
	private boolean validarFormularioEntrada(){
		boolean validador = true;
		if(this.fechaIngreso == null){
			FacesMessageUtil.showErrorMessage("La fecha debe ser ingresada.");
			validador = false;
		} 
		if(this.listaEntradas == null || this.listaEntradas.size() <= 0){
			FacesMessageUtil.showErrorMessage("Debe ingresar a lo menos un producto.");
			validador = false;
		}
		return validador;
	}
	
	public void eliminarProductoDesdeEntrada(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap(); 
		String idProdEliminar = params.get("idProd");
		int idProd = Integer.parseInt(idProdEliminar);
		for(Entrada entrada : this.listaEntradas){
			if(entrada.getProducto().getIdProd() == idProd){
				this.listaEntradas.remove(entrada);
				return;
			}
		}	
	}
	
	public void ingresarEntradas(){
		try{
			if(this.validarFormularioEntrada()){
				this.ingresarFechaEntradas();
				entradaManager.ingresarProductos(this.listaEntradas);
				this.init();
			} else {
				return;
			}
		} catch (Exception ex) {
			FacesMessageUtil.showErrorMessage("Ocurrió un error al intentar ingresar la entrada.");
			return;
		}
		FacesMessageUtil.showInfoMessage("Se han ingresado los productos satisfactoriamente.");
	}
	
	private void ingresarFechaEntradas(){
		for(Entrada ent : this.listaEntradas){
			ent.setFechaIngreso(fechaIngreso);
		}
	}
	
	public Entrada getEntrada() {
		return entrada;
	}
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Map<String,String> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Map<String,String> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Producto getProductoNuevo() {
		return productoNuevo;
	}

	public void setProductoNuevo(Producto productoNuevo) {
		this.productoNuevo = productoNuevo;
	}

	public int getCantidadIngreso() {
		return cantidadIngreso;
	}

	public void setCantidadIngreso(int cantidadIngreso) {
		this.cantidadIngreso = cantidadIngreso;
	}

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public List<Producto> getListaProductosEntrada() {
		return listaProductosEntrada;
	}

	public void setListaProductosEntrada(List<Producto> listaProductosEntrada) {
		this.listaProductosEntrada = listaProductosEntrada;
	}

	public String getProdSelec() {
		return prodSelec;
	}

	public void setProdSelec(String prodSelec) {
		this.prodSelec = prodSelec;
	}	
	
	public List<Entrada> getListaEntradas() {
		return listaEntradas;
	}

	public void setListaEntradas(List<Entrada> listaEntradas) {
		this.listaEntradas = listaEntradas;
	}

	public Entrada getEntradaBorrar() {
		return entradaBorrar;
	}

	public void setEntradaBorrar(Entrada entradaBorrar) {
		this.entradaBorrar = entradaBorrar;
	}
	
}
