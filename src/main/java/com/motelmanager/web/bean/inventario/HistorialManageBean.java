package com.motelmanager.web.bean.inventario;

import java.util.List;

import org.springframework.stereotype.Controller;

@Controller("historialBean")
public class HistorialManageBean {
	private List<Object> historial;

	public List<Object> getHistorial() {
		return historial;
	}

	public void setHistorial(List<Object> historial) {
		this.historial = historial;
	}
}
