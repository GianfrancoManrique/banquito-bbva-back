package com.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.model.Persona;

public interface IPersonaDAO extends JpaRepository<Persona, Integer>{

}
