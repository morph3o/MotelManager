package com.motelmanager.web.bean.inventario;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.motelmanager.domain.Producto;
import com.motelmanager.domain.Salida;
import com.motelmanager.service.ProductManager;
import com.motelmanager.service.SalidaManager;
import com.motelmanager.util.FacesMessageUtil;

@Controller("salidasBean")
public class SalidasManageBean {
	
	@Autowired
	private ProductManager productoManager;
	
	@Autowired
	private SalidaManager salidaManager;
	
	private int idSalida;
	private int cantidadEgreso;
	private Date fechaSalida;
	private String prodSelec;
	private Salida salidaBorrar;
	private List<Salida> listaSalidas;
	private List<Producto> listaProductos;
	private Map<String,String> listaProdDropDown;
	
	public void init(){
		listaSalidas = new ArrayList<Salida>();
		this.listaProdDropDown = new HashMap<String,String>();
		listaProductos = productoManager.listarProductos();
		for(Producto prod : listaProductos){
			this.listaProdDropDown.put(prod.getNmProd(), prod.getNmProd());
		}
		this.idSalida = this.salidaManager.obtenerUltimaIDSalida() + 1;
	}
	
	public void cargarProductoALista(){
		Producto auxProd = null;
		auxProd = this.obtenerProductoDesdeLista(prodSelec);
		if(prodSelec == null || prodSelec.isEmpty()){
			FacesMessageUtil.showErrorMessage("Debes seleccionar un producto de la lista.");
			return;
		}
		if(cantidadEgreso < 1){
			FacesMessageUtil.showErrorMessage("El valor de egreso debe ser mayor a 0.");
			return;
		}
		if(this.existeProductoListaSalida(auxProd)){
			for(Salida sal : this.listaSalidas){
				if(sal.getProducto().getIdProd() == auxProd.getIdProd()){
					sal.setCantEgreso(cantidadEgreso);
					sal.setCantExtAnt(auxProd.getCantProd());
					sal.setCantExtDesp(auxProd.getCantProd() - cantidadEgreso);
				}
			}
		} else {
			Salida salida = new Salida();			
			salida.setCantEgreso(cantidadEgreso);
			salida.setProducto(auxProd);
			salida.setCantExtAnt(auxProd.getCantProd());
			int cantFutura = auxProd.getCantProd() - cantidadEgreso;
			salida.setCantExtDesp(cantFutura);
			salida.getProducto().setCantProd(cantFutura);
			salida.setIdSalida(this.idSalida);
			
			listaSalidas.add(salida);
		}
	}
	
	private boolean existeProductoListaSalida(Producto prod){
		for(Salida sal : this.listaSalidas){
			if(sal.getProducto().getIdProd() == prod.getIdProd()){
				return true;
			}
		}
		return false;
	}
	
	private void insertarFechaSalida(){
		for(Salida sal : this.listaSalidas){
			sal.setFechaEgreso(fechaSalida);
		}
	}
	
	private boolean validarFormularioEntrada(){
		boolean validador = true;
		if(this.fechaSalida == null){
			FacesMessageUtil.showErrorMessage("La fecha debe ser ingresada.");
			validador = false;
		} 
		if(this.listaSalidas == null || this.listaSalidas.size() <= 0){
			FacesMessageUtil.showErrorMessage("Debe ingresar a lo menos un producto.");
			validador = false;
		}
		return validador;
	}
	
	public void eliminarProductoDesdeEntrada(){
		if(this.salidaBorrar != null){
			this.listaSalidas.remove(salidaBorrar);
			this.salidaBorrar = null;
		}
	}
	
	public void ingresarSalidas(){
		try{
			if(this.validarFormularioEntrada()){
				this.insertarFechaSalida();
				salidaManager.ingresarSalidas(this.listaSalidas);
				this.init();
				FacesMessageUtil.showInfoMessage("Se han ingresado los productos satisfactoriamente.");
			} else {
				return;
			}
		} catch (Exception ex) {
			FacesMessageUtil.showErrorMessage("Ocurrió un error al intentar ingresar la entrada.");
			return;
		}
	}
	
	private Producto obtenerProductoDesdeLista(String nombreProd){
		Producto auxProd = null;
		for(Producto prod : listaProductos){
			if(prod.getNmProd().equalsIgnoreCase(prodSelec)){
				auxProd = prod;
			}
		}
		return auxProd;
	}
	
	public int getIdSalida() {
		return idSalida;
	}
	public void setIdSalida(int idSalida) {
		this.idSalida = idSalida;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public List<Salida> getListaSalidas() {
		return listaSalidas;
	}
	public void setListaSalidas(List<Salida> listaSalidas) {
		this.listaSalidas = listaSalidas;
	}
	public int getCantidadEgreso() {
		return cantidadEgreso;
	}
	public void setCantidadEgreso(int cantidadEgreso) {
		this.cantidadEgreso = cantidadEgreso;
	}
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public String getProdSelec() {
		return prodSelec;
	}
	public void setProdSelec(String prodSelec) {
		this.prodSelec = prodSelec;
	}
	public Map<String, String> getListaProdDropDown() {
		return listaProdDropDown;
	}
	public void setListaProdDropDown(Map<String, String> listaProdDropDown) {
		this.listaProdDropDown = listaProdDropDown;
	}

	public Salida getSalidaBorrar() {
		return salidaBorrar;
	}

	public void setSalidaBorrar(Salida salidaBorrar) {
		this.salidaBorrar = salidaBorrar;
	}
	
}
