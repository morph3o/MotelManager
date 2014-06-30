package com.motelmanager.repository;

import com.motelmanager.domain.Entrada;

public interface EntradaDAO {
	public void ingresoProductos(Entrada entrada);
	public void eliminarEntrada(Entrada entrada);
	public void modificarEntrada(Entrada entrada);
	public int obtenerUltimaIDEntrada();
}
