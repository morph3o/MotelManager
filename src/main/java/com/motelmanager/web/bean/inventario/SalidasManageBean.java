package com.motelmanager.web.bean.inventario;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.motelmanager.domain.DetalleEntrada;
import com.motelmanager.domain.DetalleSalida;
import com.motelmanager.domain.Producto;
import com.motelmanager.domain.Salida;
import com.motelmanager.service.ProductManager;
import com.motelmanager.service.SalidaManager;
import com.motelmanager.util.DateTool;
import com.motelmanager.util.FacesMessageUtil;

@Controller("salidasBean")
public class SalidasManageBean {
	
	@Autowired
	private ProductManager productoManager;
	
	@Autowired
	private SalidaManager salidaManager;
	
	private int idSalida;
	private int cantidadEgreso;
	private String fechaSalida;
	private String prodSelec;
	private Salida salidaIngresar;
	private List<DetalleSalida> detalleSalida;
	private List<Producto> listaProductos;
	private Map<String,String> listaProdDropDown;
	
	public void init(){
		salidaIngresar = new Salida();
		fechaSalida = null;
		detalleSalida = new ArrayList<DetalleSalida>();
		this.listaProdDropDown = new HashMap<String,String>();
		listaProductos = productoManager.listarProductos();
		for(Producto prod : listaProductos){
			this.listaProdDropDown.put(prod.getNmProd(), prod.getNmProd());
		}
		this.idSalida = this.salidaManager.obtenerUltimaIDSalida() + 1;
	}
	
	private void limpiarModalIngresoProd(){
		prodSelec = "";
		cantidadEgreso = 0;
	}
	
	public void cargarProductoALista(){
		Producto auxProd = null;
		auxProd = this.obtenerProductoDesdeLista(prodSelec);
		if(!validarModalAgregarProducto()) return;
		if(this.existeProductoListaSalida(auxProd)){
			for(DetalleSalida itemDS : this.detalleSalida){
				if(itemDS.getProducto().getIdProd() == auxProd.getIdProd()){
					int cantFutura = 0;
					cantFutura = itemDS.getCantExtDesp() - cantidadEgreso;
					if(cantFutura >= 0){
						itemDS.setCantSalida(itemDS.getCantSalida() + cantidadEgreso);
						itemDS.setCantExtAnt(auxProd.getCantProd());
						itemDS.setCantExtDesp(cantFutura);
						limpiarModalIngresoProd();
						return;	
					} else {
						FacesMessageUtil.showErrorMessage("No se pueden extraer más productos de los que existen actualmente en stock");
						return;
					}
				}
			}
		} else {
			int cantFutura = 0;
			cantFutura = auxProd.getCantProd() - cantidadEgreso;
			if(cantFutura >= 0){
				DetalleSalida detalleSalidaAux = new DetalleSalida();
				detalleSalidaAux.setCantSalida(cantidadEgreso);
				detalleSalidaAux.setProducto(auxProd);
				detalleSalidaAux.setCantExtAnt(auxProd.getCantProd());
				detalleSalidaAux.setCantExtDesp(cantFutura);
				detalleSalidaAux.getProducto().setCantProd(cantFutura);
				
				detalleSalida.add(detalleSalidaAux);
				limpiarModalIngresoProd();
			} else {
				FacesMessageUtil.showErrorMessage("No se pueden extraer más productos de los que existen actualmente en stock");
				return;
			}
		}
	}
	
	private boolean existeProductoListaSalida(Producto prod){
		for(DetalleSalida itemDS : this.detalleSalida){
			if(itemDS.getProducto().getIdProd() == prod.getIdProd()){
				return true;
			}
		}
		return false;
	}
	
	private boolean validarModalAgregarProducto(){
		boolean flag = true;
		if(prodSelec == null || prodSelec.isEmpty()){
			FacesMessageUtil.showErrorMessage("Debes seleccionar un producto de la lista");
			flag = false;
		}
		if(cantidadEgreso < 1){
			FacesMessageUtil.showErrorMessage("El valor de egreso debe ser mayor a 0");
			flag = false;
		}
		return flag;
	}
	
	private boolean validarFormularioEntrada(){
		boolean validador = true;
		if(this.fechaSalida == null){
			FacesMessageUtil.showErrorMessage("La fecha debe ser ingresada");
			validador = false;
		} 
		if(this.detalleSalida == null || this.detalleSalida.size() <= 0){
			FacesMessageUtil.showErrorMessage("Debe ingresar a lo menos un producto");
			validador = false;
		}
		return validador;
	}
	
	public void eliminarProductoDesdeEntrada(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap(); 
		String idProdEliminar = params.get("idProd");
		int idProd = Integer.parseInt(idProdEliminar);
		for(DetalleSalida itemDS : this.detalleSalida){
			if(itemDS.getProducto().getIdProd() == idProd){
				this.detalleSalida.remove(itemDS);
				return;
			}
		}
	}
	
	public void ingresarSalidas(){
		try{
			if(this.validarFormularioEntrada()){
				salidaIngresar.setIdSalida(idSalida);
				salidaIngresar.setFechaEgreso(DateTool.stringToDate(fechaSalida));
				salidaManager.ingresarSalidas(salidaIngresar, this.detalleSalida);
				this.init();
				FacesMessageUtil.showInfoMessage("Se han ingresado los productos satisfactoriamente");
			} else {
				return;
			}
		} catch (Exception ex) {
			FacesMessageUtil.showErrorMessage("Ocurrió un error al intentar ingresar la entrada");
			return;
		}
	}
	
	private Producto obtenerProductoDesdeLista(String nombreProd){
		Producto auxProd = null;
		for(Producto prod : productoManager.listarProductos()){
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
	
	public String getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
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

	public List<DetalleSalida> getDetalleSalida() {
		return detalleSalida;
	}

	public void setDetalleSalida(List<DetalleSalida> detalleSalida) {
		this.detalleSalida = detalleSalida;
	}

	public Salida getSalidaIngresar() {
		return salidaIngresar;
	}

	public void setSalidaIngresar(Salida salidaIngresar) {
		this.salidaIngresar = salidaIngresar;
	}
	
}
