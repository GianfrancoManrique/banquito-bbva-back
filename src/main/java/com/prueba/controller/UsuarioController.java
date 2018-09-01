package com.prueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.Usuario;
import com.prueba.service.IUsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	@GetMapping
	public List<Usuario> listar(){
		return service.listar();
	}
	
	@GetMapping(value = "/{id}")
	public Usuario listarPorId(@PathVariable("id") Integer id){
		Optional<Usuario> op = service.listarPorId(id);
		return op.isPresent() ? op.get() : new Usuario();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario registrar(@RequestBody Usuario persona) {
		return service.registrar(persona);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario modificar(@RequestBody Usuario persona) {
		return service.modificar(persona);
	}

	@DeleteMapping(value = "/{id}")
	public Integer eliminar(@PathVariable("id") Integer id) {
		Optional<Usuario> opt = service.listarPorId(id);
		if (opt.isPresent()) {
			Usuario per = new Usuario();
			per.setId(id);
			service.eliminar(per);
			return 1;
		}
		return 0;
	}
	
	
}
