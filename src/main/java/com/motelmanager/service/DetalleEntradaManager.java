package com.motelmanager.service;

import java.io.Serializable;
import java.util.List;

import com.motelmanager.domain.DetalleEntrada;

public interface DetalleEntradaManager extends Serializable{
	public List<DetalleEntrada> listaDetalleEntrada(int idEntrada);
}
