package com.motelmanager.service;

import java.io.Serializable;
import java.util.List;

import com.motelmanager.domain.Entrada;

public interface EntradaManager extends Serializable{
	
	public void ingresarProductos(List<Entrada> entradas);
	public int obtenerUltimaIDEntrada();
	
}
