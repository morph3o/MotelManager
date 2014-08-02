package com.motelmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motelmanager.domain.DetalleEntrada;
import com.motelmanager.domain.Entrada;
import com.motelmanager.repository.DetalleEntradaDAO;
import com.motelmanager.repository.EntradaDAO;
import com.motelmanager.repository.FacturaDAO;
import com.motelmanager.repository.ProductoDAO;

@Service("entradaManager")
public class SimpleEntradaManager implements EntradaManager{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EntradaDAO entradaDAO;
	@Autowired
	private ProductoDAO prodDAO;
	@Autowired
	private FacturaDAO facturaDAO;
	@Autowired
	private DetalleEntradaDAO detalleEntradaDAO;

	@Override
	public void ingresarProductos(Entrada entrada, List<DetalleEntrada> detalleEntrada) {
		entrada.setDetalleEntradas(detalleEntrada);
		entradaDAO.ingresoProductos(entrada);
		for(DetalleEntrada itemDE : detalleEntrada){
			itemDE.setEntrada(entrada);
			detalleEntradaDAO.ingresarDetalleEntrada(itemDE);
			prodDAO.modificarProducto(itemDE.getProducto());
		}
	}

	@Override
	public int obtenerUltimaIDEntrada() {
		return entradaDAO.obtenerUltimaIDEntrada();
	}
	
}
