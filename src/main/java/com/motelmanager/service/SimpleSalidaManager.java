package com.motelmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motelmanager.domain.Salida;
import com.motelmanager.repository.FacturaDAO;
import com.motelmanager.repository.ProductoDAO;
import com.motelmanager.repository.SalidaDAO;

@Service("salidaManager")
public class SimpleSalidaManager implements SalidaManager{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SalidaDAO salidaDAO;
	@Autowired
	private ProductoDAO prodDAO;
	@Autowired
	private FacturaDAO facturaDAO;

	@Override
	public void ingresarSalidas(List<Salida> salidas) {
		for(Salida salida : salidas){
			salidaDAO.ingresarSalida(salida);
			prodDAO.modificarProducto(salida.getProducto());
		}
	}

	@Override
	public int obtenerUltimaIDSalida() {
		return salidaDAO.obtenerUltimaIDSalida();
	}

}
