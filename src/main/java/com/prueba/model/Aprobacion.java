package com.prueba.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbAprobacion")
@IdClass(CompositeKey.class)
public class Aprobacion {

	@Id
	@ManyToOne 
	@JoinColumn(name="id_prestamo")
	private Prestamo prestamo;
	

	@Id
	@ManyToOne 
	@JoinColumn(name="usuario_calificador")
	private Usuario usuarioCalificador;
	
	private Boolean aprobado;
	
	@Column(name="fecha_calificacion")
	private Date fechaCalifiacion;
	

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Date getFechaCalifiacion() {
		return fechaCalifiacion;
	}

	public void setFechaCalifiacion(Date fechaCalifiacion) {
		this.fechaCalifiacion = fechaCalifiacion;
	}

	public Usuario getUsuarioCalificador() {
		return usuarioCalificador;
	}

	public void setUsuarioCalificador(Usuario usuarioCalificador) {
		this.usuarioCalificador = usuarioCalificador;
	}

	public Boolean getAprobado() {
		return aprobado;
	}

	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}


	

}
