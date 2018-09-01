package com.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{

}
