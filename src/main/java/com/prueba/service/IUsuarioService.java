package com.prueba.service;

import java.util.List;
import java.util.Optional;

import com.prueba.model.Usuario;

public interface IUsuarioService {
	
	List<Usuario> listar();
	Optional<Usuario> listarPorId(Integer id);	
	Usuario registrar(Usuario per);
	Usuario modificar(Usuario per);
	void eliminar(Usuario per);

}
