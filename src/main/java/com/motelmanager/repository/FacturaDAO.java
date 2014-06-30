package com.motelmanager.repository;

import java.util.List;

import com.motelmanager.domain.Factura;

public interface FacturaDAO {
	
	public void ingresarFactura(Factura factura);
	public Factura obtenerFactura(int idFactura);
	public void modificarFactura(int idFactura, Factura nuevaFactura);
	public List<Factura> obtenerFacturas();
	
}
