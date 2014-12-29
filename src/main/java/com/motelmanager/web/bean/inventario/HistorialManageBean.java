package com.motelmanager.web.bean.inventario;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.motelmanager.domain.Entrada;

@Controller("historialEntradasBean")
public class HistorialManageBean {
	
	private List<Entrada> listaEntradas;

	public List<Entrada> getListaEntradas() {
		return listaEntradas;
	}

	public void setListaEntradas(List<Entrada> listaEntradas) {
		this.listaEntradas = listaEntradas;
	}
}
