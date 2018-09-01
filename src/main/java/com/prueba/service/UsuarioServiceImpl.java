package com.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.dao.IUsuarioDAO;
import com.prueba.model.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO dao;

	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Override
	public Optional<Usuario> listarPorId(Integer id) {		
		return dao.findById(id);
	}

	@Override
	public Usuario registrar(Usuario per) {
		return dao.save(per);
	}

	@Override
	public Usuario modificar(Usuario per) {
		Optional<Usuario> persona = dao.findById(per.getId());
		
		if (persona.isPresent()) {
			return dao.save(per);
		}
		return new Usuario();
	}

	@Override
	public void eliminar(Usuario per) {
		dao.delete(per);

	}

}
