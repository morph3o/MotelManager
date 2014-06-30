package com.motelmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motelmanager.domain.Entrada;
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

	@Override
	public void ingresarProductos(List<Entrada> entradas) {
		for(Entrada entrada : entradas){
			entradaDAO.ingresoProductos(entrada);
			prodDAO.modificarProducto(entrada.getProducto());
		}
	}

	@Override
	public int obtenerUltimaIDEntrada() {
		return entradaDAO.obtenerUltimaIDEntrada();
	}
	
}
