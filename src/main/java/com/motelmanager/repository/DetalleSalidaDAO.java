package com.motelmanager.repository;

import java.util.List;

import com.motelmanager.domain.DetalleSalida;
import com.motelmanager.domain.Salida;

public interface DetalleSalidaDAO {
	public void ingresarDetalleSalida(DetalleSalida detalleSalida);
	public void modificarDetalleSalida(DetalleSalida detalleSalida);
	public void eliminarDetalleSalida(DetalleSalida detalleSalida);
	public List<DetalleSalida> listaDetalleSalida(Salida salida);
}
