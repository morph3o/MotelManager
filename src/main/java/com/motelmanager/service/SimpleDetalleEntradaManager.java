package com.motelmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motelmanager.domain.DetalleEntrada;
import com.motelmanager.repository.DetalleEntradaDAO;

@Service("detalleEntradaManager")
public class SimpleDetalleEntradaManager implements DetalleEntradaManager{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DetalleEntradaDAO detalleEntradaDAO;

	@Override
	public List<DetalleEntrada> listaDetalleEntrada(int idEntrada) {
		return detalleEntradaDAO.listaDetalleEntrada(idEntrada);
	}

}
