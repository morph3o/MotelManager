package com.motelmanager.repository;

import com.motelmanager.domain.Salida;

public interface SalidaDAO {
	public void ingresarSalida(Salida salida);
	public void eliminarSalida(Salida salida);
	public int obtenerUltimaIDSalida();
}
