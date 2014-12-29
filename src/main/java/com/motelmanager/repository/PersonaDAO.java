package com.motelmanager.repository;

import com.motelmanager.domain.Persona;

public interface PersonaDAO {
	
	Persona obtenerPersonaPorNombreUsuario(String nombreUsuario) throws Exception;
	
	void guardarPersona(Persona persona) throws Exception;
	
	Persona updatePersona(Persona persona) throws Exception;
	
}
