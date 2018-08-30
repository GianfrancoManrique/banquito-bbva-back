package com.prueba.service;

import java.util.List;
import java.util.Optional;

import com.prueba.model.Persona;

public interface IPersonaService {
	
	List<Persona> listar();
	Optional<Persona> listarPorId(Integer id);	
	Persona registrar(Persona per);
	Persona modificar(Persona per);
	void eliminar(Persona per);

}
