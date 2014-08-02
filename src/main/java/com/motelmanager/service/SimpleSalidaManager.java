package com.motelmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motelmanager.domain.DetalleSalida;
import com.motelmanager.domain.Salida;
import com.motelmanager.repository.DetalleSalidaDAO;
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
	@Autowired
	private DetalleSalidaDAO detalleSalidaDAO;

	@Override
	public void ingresarSalidas(Salida salida, List<DetalleSalida> detalleSalidas) {
		salida.setDetalleSalidas(detalleSalidas);
		salidaDAO.ingresarSalida(salida);
		for(DetalleSalida itemDS : detalleSalidas){
			itemDS.setSalida(salida);
			detalleSalidaDAO.ingresarDetalleSalida(itemDS);
			prodDAO.modificarProducto(itemDS.getProducto());
		}
	}

	@Override
	public int obtenerUltimaIDSalida() {
		return salidaDAO.obtenerUltimaIDSalida();
	}

}
