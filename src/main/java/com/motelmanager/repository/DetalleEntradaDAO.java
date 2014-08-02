package com.motelmanager.repository;

import java.util.List;

import com.motelmanager.domain.DetalleEntrada;
import com.motelmanager.domain.Entrada;

public interface DetalleEntradaDAO {
	public void ingresarDetalleEntrada(DetalleEntrada detalleEntrada);
	public void modificarDetalleEntrada(DetalleEntrada detalleEntrada);
	public void eliminarDetalleEntrada(DetalleEntrada detalleEntrada);
	public List<DetalleEntrada> listaDetalleEntrada(int idEntrada);
}
