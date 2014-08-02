package com.motelmanager.service;

import java.io.Serializable;
import java.util.List;

import com.motelmanager.domain.DetalleSalida;
import com.motelmanager.domain.Salida;

public interface SalidaManager extends Serializable{
	public void ingresarSalidas(Salida salida, List<DetalleSalida> detalleSalidas);
	public int obtenerUltimaIDSalida();
}
